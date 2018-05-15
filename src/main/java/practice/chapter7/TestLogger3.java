package practice.chapter7;

import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiaoyue26 on 17/10/18.
 * 正确示例.
 * <p>
 * 1. 可以关闭
 * 2. 关时没bug
 * 3. 没阻塞
 * <p>
 * 缺陷:
 * 暂时没发现缺陷
 */
public class TestLogger3 {

    public class LogService {
        private final ExecutorService exec = Executors.newSingleThreadExecutor();
        private final PrintWriter writer;
        private final long TIMEOUT = 1000;

        public LogService(PrintWriter writer) {
            this.writer = writer;
        }

        public void start() {
        }

        public void stop() throws InterruptedException {
            try {
                exec.shutdown();
                exec.awaitTermination(TIMEOUT, TimeUnit.SECONDS);
            } finally {
                writer.close();
            }
        }

        public void log(String msg) {
            try {
                exec.execute(new WriteTask(msg));
            } catch (RejectedExecutionException e) {
            }
        }

        private class WriteTask implements Runnable {
            public WriteTask(String msg) {
                // do something
            }

            @Override
            public void run() {
                // do something
            }
        }
    }
}
