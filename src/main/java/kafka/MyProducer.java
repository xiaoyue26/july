package kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Created by xiaoyue26 on 17/12/18.
 */
public class MyProducer {

    public static void main(String[] args) {


        Properties props = new Properties();
        /*
        * 逗号分隔,等效于以前的broker.list
        * 可以从zk的 ls /brokers/ids 获取到;
        * get /brokers/ids/3
        * 通过这个列表或列表的一部分,可以访问到整个集群.
        * */
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 0);//a batch size of zero will disable batching entirely
        props.put(ProducerConfig.LINGER_MS_CONFIG, 0);//send message without delay
        /*
        * acks=0  producer不等待broker的响应
        * acks=1  等待leader返回即可.
        * acks=all 所有replicas确认后leader才会响应.
        * */
        props.put(ProducerConfig.ACKS_CONFIG, "1");//对应partition的leader写到本地后即返回成功。极端情况下，可能导致失败
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG
                , "org.apache.kafka.common.serialization.IntegerSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG
                , "org.apache.kafka.common.serialization.StringSerializer");

        //创建生产这对象
        Producer<Integer, String> producer = new KafkaProducer<>(props);
        //生成消息
        ProducerRecord<Integer, String> data
                = new ProducerRecord<>("test", "flydata");
        try {            //int i = 1;
            //发送消息
            producer.send(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.close();
    }
}
