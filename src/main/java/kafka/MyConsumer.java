package kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

/**
 * Created by xiaoyue26 on 17/12/18.
 * high level
 * 1.0.0 kafka
 */
public class MyConsumer {

    public static void main(String[] args) {
        Properties props = new Properties();
        // 理论上可以从zk上获取. bootstrap.servers
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "0");
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
        consumer.subscribe(Arrays.asList("test"));
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
}
