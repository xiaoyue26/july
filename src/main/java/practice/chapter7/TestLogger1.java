package practice.chapter7;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by xiaoyue26 on 17/10/18.
 * 简单示例:
 * 缺陷:
 * 1. 不支持关闭.
 * 2. 关闭的时候,可能会丢消息.
 * 3. 队列满的时候会堵塞.
 */
public class TestLogger1 {

    private static final int CAPACITY = 1024;
    private final BlockingQueue<String> queue;
    private final LoggerThread logger;

    public TestLogger1(Writer writer) {
        queue = new LinkedBlockingDeque<>(CAPACITY);
        logger = new LoggerThread(writer);
    }

    public void start() {
        logger.start();
    }

    public void log(String msg) throws InterruptedException {
        queue.put(msg);
    }

    private class LoggerThread extends Thread {
        private final PrintWriter writer;

        public LoggerThread(Writer writer) {
            this.writer = (PrintWriter) writer;
        }

        public void run() {
            try {
                while (true) {
                    writer.println(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writer.close();
            }
        }
    }

}
