package practice.chapter6;

import java.util.concurrent.Executor;

/**
 * Created by xiaoyue26 on 17/10/16.
 */
public class TestExecutor2 {
    // 1. 为每个请求启动一个线程的Executor
    public class ThreadPerTaskExecutor implements Executor {

        @SuppressWarnings("NullableProblems")
        @Override
        public void execute(Runnable r) {
            if (r == null)
                return;
            new Thread(r).start();
        }
    }

    // 2. 每个请求都是同一个线程串行处理的Executor
    public class SingleThreadExecutor implements Executor {
        @SuppressWarnings("NullableProblems")
        @Override
        public void execute(Runnable r) {
            r.run();// 还是用进来的线程处理,单线程. 羊毛出在羊身上.
        }
    }
}
