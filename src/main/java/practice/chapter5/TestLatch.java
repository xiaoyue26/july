package practice.chapter5;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xiaoyue26 on 17/9/26.
 */
public class TestLatch {// 测试闭锁
    // CountDownLatch await 等待计数器为0.
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);// countDown一次就能打开
        final CountDownLatch endGate = new CountDownLatch(nThreads);//countDown nThreads次才能打开(所有线程都countDown过)
        // 开10个子线程
        for (int i = 0; i < nThreads; i++) {// 先全部放出去,然后一头撞在startGate上;
            Thread t = new Thread(() -> {
                try {
                    startGate.await();// 一头撞在startGate上
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();//每个线程countDown一次
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();//ignore
                }
            });
            t.start();
        }
        long start = System.currentTimeMillis();
        System.out.println("准备开始");
        startGate.countDown();// 打开开始的门
        endGate.await();// 主线程等待全部结束. (n次countDown结束)
        System.out.println("结束等待");
        long end = System.currentTimeMillis();
        return end - start;

    }

    public static void main(String[] args) throws InterruptedException {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("running task");
            }
        };
        TestLatch testLatch = new TestLatch();
        long during = testLatch.timeTasks(10, task);
        System.out.println("Runtime: " + during);
    }

}
