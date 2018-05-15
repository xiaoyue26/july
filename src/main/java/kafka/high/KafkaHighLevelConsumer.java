package kafka.high;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.consumer.Whitelist;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiaoyue26 on 17/12/25.
 */
public class KafkaHighLevelConsumer implements Serializable {
    private Logger LOG = LoggerFactory.getLogger(getClass());
    private static int NUM_CONSUME_THREADS = 12;
    private static int MESSAGE_BUFFER_SIZE = 1024;
    private static int WAITING_SECONDS = 1;

    private String[] topics;
    private String zookeepers;
    private String groupId;
    private ConsumerConnector consumerConnector;
    private List<KafkaStream<byte[], byte[]>> streams;
    private BlockingQueue<String> messageBuffer;

    public KafkaHighLevelConsumer(String[] topics, String zookeepers, String groupId) {
        this.topics = topics;
        this.zookeepers = zookeepers;
        this.groupId = groupId;
    }

    public void prepare() {
        consumerConnector = createConsumerConnector();
        String rawRegex = String.join("|", topics);
        Whitelist whitelist = new Whitelist(rawRegex);

        streams = consumerConnector.createMessageStreamsByFilter(whitelist, NUM_CONSUME_THREADS);
        consumerConnector.commitOffsets(true);
        if (CollectionUtils.isEmpty(streams)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOG.info("", e);
            }
            streams = consumerConnector.createMessageStreamsByFilter(whitelist, NUM_CONSUME_THREADS);
        }

        messageBuffer = new LinkedBlockingQueue<String>(MESSAGE_BUFFER_SIZE);
        for (KafkaStream<byte[], byte[]> stream : streams) {
            Thread consumeThread = new KafkaHighLevelConsumeThread(stream, messageBuffer);
            consumeThread.start();
        }
    }

    private ConsumerConnector createConsumerConnector() {
        Properties properties = new Properties();
        properties.put("auto.offset.reset", "largest");
        properties.put("zookeeper.connect", zookeepers);
        properties.put("group.id", groupId);
        properties.put("zookeeper.sync.time.ms", "200");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("socket.receive.buffer.bytes", "" + 1024 * 1024);
        ConsumerConfig conf = new ConsumerConfig(properties);
        return kafka.consumer.Consumer.createJavaConsumerConnector(conf);
    }

    public List<String> consumeMessage(int readsNum) throws InterruptedException {
        List<String> messages = new ArrayList<>();
        while (readsNum-- > 0) {
            String message = messageBuffer.poll(WAITING_SECONDS, TimeUnit.SECONDS);
            if (!StringUtils.isEmpty(message)) {
                messages.add(message);
            }
        }
        return messages;
    }

    public void shutdown() {
        consumerConnector.shutdown();
    }

    public ConsumerConnector getConsumerConnector() {
        return consumerConnector;
    }

    public static void main(String[] args) throws Exception {
        String topic = "december";
        KafkaHighLevelConsumer consumer = new KafkaHighLevelConsumer(
                new String[]{topic}
                , "pipe-zk1"
                , "groupid");
        consumer.prepare();
        while (true) {
            List<String> lines = consumer.consumeMessage(2);
            for (String line : lines) {
                System.out.println(line);
            }
        }
    }
}
