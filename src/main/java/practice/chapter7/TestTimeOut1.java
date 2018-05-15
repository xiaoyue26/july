package practice.chapter7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiaoyue26 on 17/10/18.
 * 限时取消.
 * 封装限时操作示例1. (错误示例)
 */
public class TestTimeOut1 {

    private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(10);

    public static void timeRun(Runnable r, long timeout, TimeUnit t) {
        final Thread taskThread = Thread.currentThread();
        cancelExec.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, t);
        r.run();
    }

    public static void main(String[] args) {
        /* 任意外部代码可能调用timeRun(),假设限时为1秒.
         * 1. 如果 r.run()耗时少于1秒,则这个方法在1秒后中断了调用者之后正常的处理;(产生错误)
         * 2. 如果 r.run()耗时超过1秒,则这个方法可能正确限时;
         *          如果恰好r.run()不接受中断,则这个方法还是不能正确限时,会超时.
         */

    }
}
