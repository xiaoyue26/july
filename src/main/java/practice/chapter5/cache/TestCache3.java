package practice.chapter5.cache;

import practice.chapter5.TestFutureTask;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by xiaoyue26 on 17/10/16.
 * 比2多一个Future/FutureTask;
 * 同步锁不够严密.
 */
public class TestCache3 {
    public class Memoizer3<A, V> implements TestCache1.Computable<A, V> {
        private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
        private final TestCache1.Computable<A, V> c;

        public Memoizer3(TestCache1.Computable<A, V> c) {
            this.c = c;
        }


        @Override
        public V compute(final A arg) throws InterruptedException {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> eval = () -> c.compute(arg);
                FutureTask<V> ft = new FutureTask<V>(eval);
                f = ft;// ??
                cache.put(arg, ft);
                ft.run();// 里头将调用c.compute()
            }
            try {
                return f.get();
            } catch (ExecutionException e) {
                //throw InterruptedException(e);
                throw TestFutureTask.launderThrowable(e);
            }
        }
    }

}
