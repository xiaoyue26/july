package practice.chapter7;

import practice.chapter5.TestFutureTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiaoyue26 on 17/10/18.
 * 限时取消.
 * 普通示例. 基本思想和1一样.
 * 相比于1,多封了一层线程,避免中断信号误传给调用者;
 * 缺陷:
 * 无法区分返回的原因是: join超时; 还是线程正常退出.
 *
 */
public class TestTimeOut2 {
    private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(10);

    public static void timeRun(final Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        class RethrowableTask implements Runnable {
            private volatile Throwable t;//保存异常,以便最后抛出

            @Override
            public void run() {
                try {
                    r.run();
                } catch (Throwable t) {
                    this.t = t;
                }
            }

            private void rethrow() {
                if (t != null) {
                    throw TestFutureTask.launderThrowable(t);
                }
            }
        }
        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        taskThread.start();
        cancelExec.schedule(() -> taskThread.interrupt(), timeout, unit);
        taskThread.join(unit.toMillis(timeout));
        task.rethrow();

    }
}
