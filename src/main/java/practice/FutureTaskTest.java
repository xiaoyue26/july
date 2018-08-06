package practice;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xiaoyue26
 */
public class FutureTaskTest {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> callable = () -> {
            Integer res = new Random().nextInt(100);
            System.out.println(res);
            return res;
        };

        FutureTask<Integer> future = new FutureTask<>(callable);
        // 方法1: 可以由当前线程执行:
        future.run();
        // 方法2: 可以由别的线程来执行:
        new Thread(future).start();
        System.out.println(future.get());
        // 但是FutureTask的run只会执行一次。


    }
}
