package kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

/**
 * Created by xiaoyue26 on 18/1/22.
 * 经测试,kafka1.0.0的api不能访问 0.8.2.1的服务端(多半是因为低版本的kafka还是依赖zk,没有把offset存到某个topic里头)
 */
public class MyConsumer2 {
    public void test1() {
        Properties props = new Properties();
        // 理论上可以从zk上获取. bootstrap.servers
        String bootstrap = "dx-pipe-sata11-pm:9092,dx-pipe-sata12-pm:9092,dx-pipe-sata13-pm:9092,dx-pipe-sata14-pm:9092,dx-pipe-sata15-pm:9092";
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "groupid");
        //props.put(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID());
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG
                , "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG
                , "org.apache.kafka.common.serialization.StringDeserializer");


        KafkaConsumer<Integer, String> consumer = new KafkaConsumer<>(props
                , new IntegerDeserializer()
                , new StringDeserializer()
        );
        consumer.subscribe(Arrays.asList("december"));
        System.out.println("before poll");
        ConsumerRecords<Integer, String> r = consumer.poll(0);
        for (ConsumerRecord<Integer, String> record : r)
            System.out.println(record.offset() + ": " + record.value());

        Set<TopicPartition> tp = consumer.assignment();
        System.out.println("tp.size:" + tp.size());
        for (TopicPartition t : tp) {
            System.out.println(t.partition());
            System.out.println(t.topic());
            System.out.println(t);
        }
        consumer.seekToBeginning(tp);

        try {
            while (true) {
                ConsumerRecords<Integer, String> records = consumer.poll(1000);
                for (ConsumerRecord<Integer, String> record : records)
                    System.out.println(record.offset() + ": " + record.value());
            }
        } finally {
            consumer.close();
        }
    }

    public static void main(String[] args) {
        MyConsumer2 obj = new MyConsumer2();
        obj.test1();
        System.out.println("there");
    }
}
