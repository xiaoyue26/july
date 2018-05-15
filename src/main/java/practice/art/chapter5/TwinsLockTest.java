package practice.art.chapter5;
import practice.art.chapter4.SleepUtils;

import java.util.concurrent.locks.Lock;

public class TwinsLockTest {
    public void test1() {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            @Override
            public void run() {
                for (; ; ) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        // 10个线程,同一时刻只有两个线程能够获取到TwinsLock锁
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        // 每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TwinsLockTest obj = new TwinsLockTest();
        obj.test1();
    }
}