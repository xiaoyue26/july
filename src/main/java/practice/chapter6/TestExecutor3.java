package practice.chapter6;

import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by xiaoyue26 on 17/10/16.
 */
public class TestExecutor3 {
    private ExecutorService es;

    /**
     * Timer的缺陷:
     * 1. 单线程,某个任务耗时太长的话,会影响后续的精确性
     * 2. 线程泄漏,抛异常后会产生.
     * <p>
     * 建议:
     * 使用ScheduledThreadPoolExecutor代替Timer
     */
    public static void testTimer1() {// 基于系统时间(绝对时间)
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
                           @Override
                           public void run() {
                               System.out.println("hello time");
                           }
                       }
                , 2000, 1000
        );
        // 延迟2秒后,每隔1秒运行.
    }

    public static void testTimer2() {// 体现缺陷2.
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
        try {
            SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.schedule(new ThrowTask(), 1);
        try {
            SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    static class ThrowTask extends TimerTask {

        @Override
        public void run() {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        testTimer2();
    }

}
