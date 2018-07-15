package practice.grammer;


import java.util.concurrent.*;

/**
 * Created by xiaoyue26 on 18/1/3.
 */
public class Test1 {


    private void test1() {
        Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        // 直接用封装好的:
        ExecutorService es = Executors.newCachedThreadPool();
        // 手动自定义详细参数:
        ExecutorService es2 = new ThreadPoolExecutor(10, 10, 101, TimeUnit.SECONDS
                , new LinkedBlockingQueue<Runnable>(2000));

        // ThreadPoolExecutor->AbstractExecutorService->ExecutorService
        LinkedTransferQueue<Integer> integerQueue = new LinkedTransferQueue<>();
        try {
            integerQueue.take();
            integerQueue.transfer(1);// SYNC
            integerQueue.offer(2);// ASYNC
            integerQueue.tryTransfer(2);// NOW
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ConcurrentLinkedQueue e ;

    }

    public static void main(String[] args) {
        Test1 obj = new Test1();
        System.out.println(1 / (Math.pow(2, 32)) > 0);
        //obj.test1();
        System.out.println("there");
    }
}
