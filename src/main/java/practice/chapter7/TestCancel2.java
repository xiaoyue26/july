package practice.chapter7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * Created by xiaoyue26 on 17/10/16.
 * 取消任务的正确示例.
 */
public class TestCancel2 {
    class PrimeProducer extends Thread {
        private final BlockingQueue<BigInteger> queue;

        PrimeProducer(BlockingQueue<BigInteger> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                BigInteger p = BigInteger.ONE;
                while (!Thread.currentThread().isInterrupted()) {// 检查是否中断.
                    queue.put(p = p.nextProbablePrime());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                /*
                 * 一般处理策略:
                 * 1. 捕获;
                 * 2. do 自定义存盘工作;
                 * 3. 接着往外抛,提醒调用者.
                 * ( Thread.currentThread().interrupt();
                 * )
                 *
                 * 本代码中由于不需要提醒调用者,因此没有接着往外抛.
                * */
            }

        }

        public void cancel() {
            interrupt();
        }
    }

}
