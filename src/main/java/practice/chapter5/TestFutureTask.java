package practice.chapter5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by xiaoyue26 on 17/10/15.
 */
public class TestFutureTask {
    private class ProductInfo {
        String info = "hello info";
    }

    private final FutureTask<ProductInfo> futureTask = new FutureTask<>
            (() -> loadProductInfo());

    private final Thread thread = new Thread(futureTask);

    public void start() {
        System.out.println("calling start");
        thread.start();
    }

    public ProductInfo get() throws ExecutionException, InterruptedException {
        System.out.println("calling get");
        return futureTask.get();
    }

    private ProductInfo loadProductInfo() {
        System.out.println("calling loadProductInfo");
        return new ProductInfo();
    }

    public static RuntimeException launderThrowable(Throwable t) {//经常用得到的封装
        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        }
        if (t instanceof Error) {
            throw (Error) t;
        } else {
            throw new IllegalStateException("Not unchecked", t);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestFutureTask test = new TestFutureTask();
        test.start();//注释本行则,get()的时候会永远阻塞; start导致loadProductInfo和start被调用
        String res = test.get().info;//仅导致get被调用
        System.out.println("return result:");
        System.out.println(res);
    }


}
