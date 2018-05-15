package practice.chapter7;

import practice.chapter5.TestFutureTask;

import java.util.concurrent.*;

/**
 * Created by xiaoyue26 on 17/10/18.
 * 限时取消.
 * 正确示例.
 * 使用库里现有的限时方法. // task.get(timeout, unit);
 */
public class TestTimeOut3 {
    private static final ScheduledExecutorService taskExec = Executors.newScheduledThreadPool(10);

    public static void timeRun(final Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        Future<?> task = taskExec.submit(r);
        // Future<Object> task2 = taskExec.submit(r);
        try {
            task.get(timeout, unit);
        } catch (TimeoutException e) {
            e.printStackTrace();// 之后进入finally
        } catch (ExecutionException e) {
            throw TestFutureTask.launderThrowable(e);//之前进入finally
        } finally {
            task.cancel(true);
        }


    }

}
