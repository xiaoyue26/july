package kafka.high;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

/**
 * Created by xiaoyue26 on 17/12/25.
 */
public class KafkaHighLevelConsumeThread extends Thread {
    private Logger LOG = LoggerFactory.getLogger(getClass());
    private KafkaStream stream;
    private BlockingQueue<String> buffer;

    public KafkaHighLevelConsumeThread(KafkaStream stream, BlockingQueue<String> buffer) {
        this.stream = stream;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        ConsumerIterator<byte[], byte[]> iterator = stream.iterator();
        while (iterator.hasNext()) {
            MessageAndMetadata messageAndMetadata = iterator.next();
            String message = new String((byte[]) messageAndMetadata.message());
            try {
                buffer.put(message);
            } catch (InterruptedException e) {
                LOG.warn("", e);
            }
        }
    }
}
