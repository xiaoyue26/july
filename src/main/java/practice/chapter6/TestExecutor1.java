package practice.chapter6;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by xiaoyue26 on 17/10/16.
 */
public class TestExecutor1 {

    private static final int N = 100;
    // 定长线程池
    private static final Executor exec = Executors.newFixedThreadPool(N);


    public static void main(String[] args) {
        Runnable task = () -> System.out.println("do something");
        exec.execute(task);
    }
}
