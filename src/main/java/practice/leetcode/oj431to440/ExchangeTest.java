package practice.leetcode.oj431to440;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiaoyue26
 */
public class ExchangeTest {
    private static final Exchanger<String> exchange = new Exchanger<>();
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(2);


    public void test() {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "流水A";
                try {
                    String B = exchange.exchange(A);
                    System.out.println("A中看到的是: " + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String B = "流水B";
                try {
                    String A = exchange.exchange(B);
                    System.out.println("B中看到的是: " + A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }

    public static void main(String[] args) {
        ExchangeTest obj = new ExchangeTest();
        obj.test();
    }
}
