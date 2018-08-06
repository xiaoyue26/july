package practice.forkjoin;

import java.util.concurrent.*;

/**
 * @author xiaoyue26
 */
public class CountTask extends RecursiveTask<Integer> {
    private final static int THREDSHOLD = 2;
    private final int start;
    private final int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THREDSHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 任务太大, 分治
            int mid = start + (end - start) / 2;
            CountTask left = new CountTask(start, mid);
            CountTask right = new CountTask(mid + 1, end);
            left.fork();
            right.fork();
            int leftRes = left.join();
            int rightRes = right.join();
            sum = leftRes + rightRes;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();// 可以传入并行度参数, 不传则默认从Runtime取核数作为并行度
        // Runtime.getRuntime().availableProcessors()


        CountTask task = new CountTask(1, 10);// RecursiveTask=> ForkJoinTask
        Future<Integer> res = forkJoinPool.submit(task);// ForkJoinTask
        System.out.print(res.get());


    }
}
