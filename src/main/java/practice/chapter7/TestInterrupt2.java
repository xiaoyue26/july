package practice.chapter7;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Created by xiaoyue26 on 17/10/18.
 * 处理难以直接中断的操作.
 * 复杂方法: 继承拓展Future.
 *
 */
public class TestInterrupt2 {
    public interface CancelableTask<T> extends Callable<T> {
        void cancel();

        RunnableFuture<T> newTask();
    }

    public abstract class SocketUsingTask<T> implements CancelableTask<T> {
        @GuardedBy("this")
        private Socket socket;

        protected synchronized void setSocket(Socket s) {
            socket = s;
        }

        public synchronized void cancel() {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();// ignore e
            }
        }

        public RunnableFuture<T> newTask() {
            return new FutureTask<T>(this) {
                public boolean cancel(boolean mayInterruptIfRunning) {
                    try {
                        SocketUsingTask.this.cancel();
                    } finally {
                        return super.cancel(mayInterruptIfRunning);
                    }
                }
            };
        }
    }

    @ThreadSafe
    public class CancellingExecutor extends ThreadPoolExecutor {
        public CancellingExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
            if (callable instanceof CancelableTask) {
                return ((CancelableTask) callable).newTask();
            } else {
                return super.newTaskFor(callable);
            }
        }
    }

}
