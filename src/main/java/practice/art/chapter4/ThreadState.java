package practice.art.chapter4;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by xiaoyue26 on 18/2/3.
 */
public class ThreadState {
    public void test1() {
        new Thread(new TimeWaiting(),"TimeWaitingThread").start(); // TIMED_WAITING (sleeping)
        new Thread(new Waiting(),"WaitingThread").start();  // WAITING (on object monitor)
        new Thread(new Blocked(),"BlockedThread-1").start();// 获得锁 // TIMED_WAITING (sleeping)
        new Thread(new Blocked(),"BlockedThread-2").start();// 被阻塞 // BLOCKED (on object monitor)


        // Block1和TimeWaiting都是最终进入sleep(100),所以是Time_waiting
        // Block2在等Block1的锁,所以是Blocked
        // Waiting在无限制得等Waiting.class的notify,所以是Waiting.

    }

    public static void main(String[] args) {
        ThreadState obj = new ThreadState();
        obj.test1();
        System.out.println("finished.");
    }
}
