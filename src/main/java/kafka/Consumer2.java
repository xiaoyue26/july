package kafka;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 18/1/22.
 */
public class Consumer2 {
    public void test1() {

        /*Map<String, Object> config = new HashMap<>();
        String brokerList = "dx-pipe-sata11-pm:9092,dx-pipe-sata12-pm:9092,dx-pipe-sata13-pm:9092,dx-pipe-sata14-pm:9092,dx-pipe-sata15-pm:9092";
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                brokerList);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "groupid");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());

        // 2
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(config);
        consumer.subscribe("december");

        Map<String, ConsumerRecords<String, String>> records = consumer.poll(0);
        if (records != null)
            System.out.println(records);
        else
            System.err.println("null");*/

    }

    public static void main(String[] args) {
        Consumer2 obj = new Consumer2();
        obj.test1();
        System.out.println("there");
    }
}
