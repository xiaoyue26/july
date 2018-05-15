package practice.chapter7;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by xiaoyue26 on 17/10/16.
 * 取消任务的肤浅示例.
 *
 * 方法: 使用取消信号;//但其实最合理的方式应该使用中断.
 *
 * 缺陷:
 * 1. while循环中不能有阻塞,否则无法取消.
 * 需要检查while循环中的每一行代码,确保安全比较麻烦.
 *
 *
 */
public class TestCancel1 {
    @ThreadSafe
    public class PrimeGenerator implements Runnable {
        @GuardedBy("this")
        private final List<BigInteger> primes = new ArrayList<>();
        private volatile boolean cancelled = false;// 或AtomicBoolean


        @Override
        public void run() {
            BigInteger p = BigInteger.ONE;
            while (!cancelled) {// 轮询取消标志
                p = p.nextProbablePrime();
                System.out.println(p);
                synchronized (this) {
                    primes.add(p);
                }
            }

        }

        public void cancel() {
            cancelled = true;
        }

        public synchronized List<BigInteger> get() {
            return new ArrayList<>(primes);
        }
    }


    private List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator gen = new PrimeGenerator();
        new Thread(gen).start();
        try {
            SECONDS.sleep(1);
        } finally {
            gen.cancel();
        }
        return gen.get();
    }

    public static void main(String[] args) throws InterruptedException {
        TestCancel1 tc1 = new TestCancel1();
        Object o = tc1.aSecondOfPrimes();
        System.out.println(o);
    }

}
