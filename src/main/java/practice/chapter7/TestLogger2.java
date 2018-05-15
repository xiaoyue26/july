package practice.chapter7;

import javax.annotation.concurrent.GuardedBy;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by xiaoyue26 on 17/10/18.
 * 复杂示例:
 * 改进:
 * 1. 支持关闭
 * 2. 关闭时不会丢消息; // 用reservations记录剩余要处理的日志条数,(不用queue记录的原因是,queue比较慢)
 *
 * 缺陷:
 * 队列满时会堵塞.  (这个应该是无解的?)
 */
public class TestLogger2 {
    public class LogService {
        private static final int CAPACITY = 1024;
        private final BlockingQueue<String> queue;
        private final LoggerThread loggerThread;
        private final PrintWriter writer;
        @GuardedBy("this")
        private boolean isShutdown;
        @GuardedBy("this")
        private int reservations;

        public LogService(PrintWriter writer) {
            this.writer = writer;
            queue = new LinkedBlockingDeque<>(CAPACITY);
            loggerThread = new LoggerThread();
        }

        public void start() {
            loggerThread.start();
        }

        public void stop() {
            synchronized (this) {
                isShutdown = true;
            }
            loggerThread.interrupt();
        }

        public void log(String msg) throws InterruptedException {
            synchronized (this) {
                if (isShutdown) {
                    throw new IllegalStateException("logger already shutdown");
                }
                ++reservations;
            }
            queue.put(msg);

        }


        private class LoggerThread extends Thread {
            public void run() {
                try {
                    while (true) {
                        try {
                            synchronized (LogService.this) {
                                if (isShutdown && reservations == 0) {
                                    break;
                                }
                            }
                            String msg = queue.take();
                            synchronized (LogService.this) {
                                --reservations;
                            }
                            writer.println(msg);
                        } catch (InterruptedException e) {
                            e.printStackTrace();// retry
                        }
                    }
                } finally {
                    writer.close();
                }
            }
        }
    }

}
