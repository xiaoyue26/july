package kafka.learn;

/**
 * Created by xiaoyue26 on 17/12/25.
 */

import kafka.api.FetchRequest;
import kafka.api.FetchRequestBuilder;
import kafka.api.OffsetRequest;
import kafka.api.PartitionOffsetRequestInfo;
import kafka.common.ErrorMapping;
import kafka.common.TopicAndPartition;
import kafka.javaapi.FetchResponse;
import kafka.javaapi.OffsetResponse;
import kafka.javaapi.PartitionMetadata;
import kafka.javaapi.TopicMetadata;
import kafka.javaapi.TopicMetadataRequest;
import kafka.javaapi.consumer.SimpleConsumer;
import kafka.message.MessageAndOffset;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class KafkaLowLevelConsumer implements Serializable {
    private Logger LOG = LoggerFactory.getLogger(getClass());
    private static final int TIMEOUT = 100000;
    private static final int BUFFERSIZE = 1024 * 1024;
    private static final int FETCHSIZE = 1024 * 1024;
    private static final int FETCHERRORSCEILING = 5;
    private static final String UTF8 = "utf-8";
    private String zookeepers;
    private String zkNode;
    private SimpleConsumer simpleConsumer;
    private String[] seedBrokers;
    private int port;
    private String topic;
    private int partition;
    private long offset;
    private ZookeeperIO zk = null;
    private String clientName;
    private String offsetPath;
    private int timeout;
    private int bufferSize;
    private long boundTime;

    public KafkaLowLevelConsumer(String zookepers, String zkNode, String[] seedBrokers, int port, String topic,
                                 int partition, String clientName) {
        this(zookepers, zkNode, seedBrokers, port, topic, partition, clientName, kafka.api.OffsetRequest.LatestTime());
    }

    public KafkaLowLevelConsumer(String zookepers, String zkNode, String[] seedBrokers, int port, String topic,
                                 int partition, String clientName, long boundTime) {
        this(zookepers, zkNode, seedBrokers, port, topic, partition, clientName, boundTime, TIMEOUT, BUFFERSIZE);
    }

    public KafkaLowLevelConsumer(String zookepers, String zkNode, String[] seedBrokers, int port, String topic,
                                 int partition, String clientName, long boundTime, int timeout, int bufferSize) {

        this.zookeepers = zookepers;
        while (zkNode.endsWith("/")) {
            zkNode = zkNode.substring(0, zkNode.length() - 1);
        }
        this.zkNode = zkNode;
        this.seedBrokers = seedBrokers;
        this.port = port;
        this.topic = topic;
        this.partition = partition;
        this.clientName = "Client_" + topic + "_" + partition + "_" + clientName;
        this.zk = new ZookeeperIO();
        this.offsetPath = this.zkNode + "/" + this.clientName;
        this.timeout = timeout;
        this.bufferSize = bufferSize;
        this.boundTime = boundTime;
    }

    public void prepare() throws Exception {
        SetupConsumerForLeadBroker();
        zk.connect(zookeepers);
        // Using startTime to generate offset if there is no on zk
        if (zk.exist(offsetPath)) {
            offset = Long.valueOf(new String(zk.getData(offsetPath), UTF8));
        } else {
            zk.create(this.offsetPath);
            offset = getLastOffset(boundTime);
            zk.setData(offsetPath, (offset + "").getBytes(UTF8));
        }
    }

    private void SetupConsumerForLeadBroker() {

        for (String seed : seedBrokers) {
            SimpleConsumer consumer = null;
            try {
                consumer = new SimpleConsumer(seed, port, TIMEOUT, BUFFERSIZE, clientName);

                List<String> topics = Collections.singletonList(topic);
                TopicMetadataRequest req = new TopicMetadataRequest(topics);
                kafka.javaapi.TopicMetadataResponse resp = consumer.send(req);

                List<TopicMetadata> metaData = resp.topicsMetadata();

                for (TopicMetadata item : metaData) {
                    for (PartitionMetadata part : item.partitionsMetadata()) {
                        if (part.partitionId() == partition) {
                            simpleConsumer = new SimpleConsumer(part.leader().host(), port, timeout, bufferSize, clientName);
                        }
                    }
                }
            } catch (Exception e) {
                LOG.warn("Error communicating with Broker [" + seed + "] to find Leader for [" + topic
                        + ", " + partition + "] Reason: " + e);
            } finally {
                if (consumer != null) consumer.close();
            }
        }
    }

    private long getLastOffset(long startTime) {
        TopicAndPartition topicAndPartition = new TopicAndPartition(topic, partition);
        Map<TopicAndPartition, PartitionOffsetRequestInfo> requestInfo = new HashMap<TopicAndPartition, PartitionOffsetRequestInfo>();
        requestInfo.put(topicAndPartition, new PartitionOffsetRequestInfo(startTime, 1));
        kafka.javaapi.OffsetRequest request = new kafka.javaapi.OffsetRequest(requestInfo, kafka.api.OffsetRequest.CurrentVersion(), clientName);
        OffsetResponse response = simpleConsumer.getOffsetsBefore(request);

        if (response.hasError()) {
            LOG.warn("Error fetching offset from broker. Reason: " + response.errorCode(topic, partition));
            simpleConsumer.close();
            return -1;
        }
        long[] offsets = response.offsets(topic, partition);
        simpleConsumer.close();
        return offsets[0];
    }

    public void updateOffset(long offset) throws Exception {
        this.offset = offset;
        zk.setData(offsetPath, ("" + offset).getBytes(UTF8));
    }

    public Pair<LinkedList<String>, Long> consumeMessage(long maxReads) throws Exception {
        Pair<LinkedList<String>, Long> ret = new MutablePair(new LinkedList<String>(), 0L);
        long tmpOffset = offset;
        int numErrors = 0;
        while (maxReads > 0) {
            FetchRequest req = new FetchRequestBuilder()
                    .clientId(clientName)
                    .addFetch(topic, partition, tmpOffset, FETCHSIZE)
                    .build();

            FetchResponse fetchResponse = null;
            try {
                fetchResponse = simpleConsumer.fetch(req);
            } catch (Exception e) {
                LOG.warn("exception during simpleConsumer.fetch");
                SetupConsumerForLeadBroker();
                Thread.sleep(1000);
                numErrors++;
                continue;
            }

            if (fetchResponse != null && fetchResponse.hasError()) {
                short code = fetchResponse.errorCode(topic, partition);
                if (code == ErrorMapping.OffsetOutOfRangeCode()) {
                    LOG.warn("Error fetching data from the Broker (offset out of range):" + simpleConsumer.host() + " code: " + code);
                    tmpOffset = getLastOffset(OffsetRequest.LatestTime());
                    updateOffset(tmpOffset);
                    numErrors++;
                } else if (code == ErrorMapping.LeaderNotAvailableCode() || code == ErrorMapping.NotLeaderForPartitionCode()
                        || code == ErrorMapping.BrokerNotAvailableCode()) {
                    LOG.warn("Error fetching data from the Broker:" + simpleConsumer.host() + " code: " + code);
                    Thread.sleep(1000);
                    SetupConsumerForLeadBroker();
                    numErrors++;
                } else if (code == ErrorMapping.MessageSizeTooLargeCode()) {
                    LOG.warn("message too large");
                } else {
                    LOG.warn("Error fetching data from the Broker:" + simpleConsumer.host() + " code: " + code);
                    numErrors++;
                }
                if (numErrors > FETCHERRORSCEILING) {
                    LOG.warn("too many errors when fetching");
                    throw new Exception("too many errors when fetching");
                }
                simpleConsumer.close();
                continue;
            }

            for (MessageAndOffset messageAndOffset : fetchResponse.messageSet(topic, partition)) {

                long currentOffset = messageAndOffset.offset();
                if (currentOffset < tmpOffset) {
                    LOG.warn("Found an old offset: " + currentOffset + " Expecting: " + offset);
                    continue;
                }
                tmpOffset = messageAndOffset.nextOffset();
                ByteBuffer payload = messageAndOffset.message().payload();
                byte[] bytes = new byte[payload.limit()];
                payload.get(bytes);
                ret.getKey().add(new String(bytes, UTF8));
                maxReads--;
            }
            numErrors = 0;
        }
        ret.setValue(tmpOffset);
        return ret;
    }

    public void shutdown() {
        simpleConsumer.close();
        zk.close();
    }

    private void test1() throws Exception {
        System.out.println("work start");
        KafkaLowLevelConsumer consumer = new KafkaLowLevelConsumer("dx-pipe-zk1-online:2181", "/realtime",
                new String[]{"dx-pipe-sata11-pm", "dx-pipe-sata12-pm", "dx-pipe-sata13-pm", "dx-pipe-sata14-pm", "dx-pipe-sata15-pm"},
                9092, "anotherTest", 0, "testtest", OffsetRequest.EarliestTime());
        consumer.prepare();
        long lines = 0L;
        while (true) {
            Pair<LinkedList<String>, Long> pair = consumer.consumeMessage(100);
            LinkedList<String> message = pair.getLeft();
            long offset = pair.getRight();
            for (String line : message) {
                System.out.println(line);
            }
            consumer.updateOffset(offset);
        }
        //       consumer.shutdown();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("work start");
        KafkaLowLevelConsumer consumer = new KafkaLowLevelConsumer(
                "localhost:2181"
                , "/lowlevel"
                , new String[]{"localhost"}
                , 9092
                , "test"
                , 0
                , "testClient"
                , OffsetRequest.EarliestTime());
        consumer.prepare();
        while (true) {
            Pair<LinkedList<String>, Long> pair = consumer.consumeMessage(2);
            LinkedList<String> message = pair.getLeft();
            long offset = pair.getRight();
            for (String line : message) {
                System.out.println(line);
            }
            consumer.updateOffset(offset);
        }
        //       consumer.shutdown();
    }
}
