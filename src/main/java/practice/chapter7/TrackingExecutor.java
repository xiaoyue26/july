package practice.chapter7;

import java.util.*;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiaoyue26 on 18/1/4.
 */
public class TrackingExecutor extends AbstractExecutorService {

    private final ExecutorService exec;// 真正干活的.
    private final Set<Runnable> tasksCancel = Collections.synchronizedSet(new HashSet<Runnable>());

    public TrackingExecutor(ExecutorService exec) {
        this.exec = exec;
    }

    @Override
    public void shutdown() {
        exec.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return exec.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return exec.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return exec.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return exec.awaitTermination(timeout, unit);
    }

    @Override
    public void execute(final Runnable runnable) {
        exec.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    runnable.run();
                } finally {
                    if (isShutdown() && Thread.currentThread().isInterrupted()) {
                        tasksCancel.add(runnable);
                    }
                }
            }
        });
    }

    public List<Runnable> getCancelledTaks() {
        if (!exec.isTerminated()) {
            throw new IllegalStateException("线程池还没关闭");
        }
        return new ArrayList<>(tasksCancel);// 返回静态镜像. 线程安全.
    }
}
