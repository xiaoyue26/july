package practice.leetcode.oj411to420;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author xiaoyue26
 */
public class ForkJoinTest {
    public static class CountTask extends RecursiveTask<Integer> {
        private static final int THREDHOLD = 2;
        private int start;
        private int end;

        public CountTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            boolean canCompute = (end - start) <= THREDHOLD;
            if (canCompute) {
                for (int i = start; i <= end; ++i) {
                    sum += i;
                }
            } else {// fork
                int mid = (start + end) / 2;// map
                CountTask left = new CountTask(start, mid);
                CountTask right = new CountTask(mid + 1, end);
                left.fork();
                right.fork();
                int leftResult = left.join();
                int righResult = right.join();
                sum = leftResult + righResult; // reduce
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        CountTask task = new CountTask(1, 4);
        Future<Integer> res = pool.submit(task);
        try {
            System.out.println(res.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
