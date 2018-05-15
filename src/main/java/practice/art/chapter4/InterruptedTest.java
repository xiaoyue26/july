package practice.art.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * Created by xiaoyue26 on 18/2/3.
 */
public class InterruptedTest {

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    // 这里接到异常之前,中断位已经被重置为false了.
                    System.out.println("自己线程中看: " + Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new SleepRunner(), "sleepThread");
        thread.setDaemon(true);// main线程结束后,thread自动终止
        thread.start();

        SleepUtils.second(5);
        thread.interrupt();

        System.out.println("main线程中看: "+thread.isInterrupted());

        SleepUtils.second(2);

    }
}
