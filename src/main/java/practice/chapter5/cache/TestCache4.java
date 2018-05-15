package practice.chapter5.cache;

import practice.chapter5.TestFutureTask;

import java.util.concurrent.*;

/**
 * Created by xiaoyue26 on 17/10/16.
 * 最终方案 多了putIfAbsent
 * <p>
 * putIfAbsent:
 * 如果原来有  ,返回原来的值;
 * 如果原来没有,返回null,并且放入新的值.
 */
public class TestCache4 {
    public class Memoizer4<A, V> implements TestCache1.Computable<A, V> {
        private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
        private final TestCache1.Computable<A, V> c;

        public Memoizer4(TestCache1.Computable<A, V> c) {
            this.c = c;
        }

        @Override
        public V compute(final A arg) throws InterruptedException {
            while (true) {
                Future<V> f = cache.get(arg);
                if (f == null) {
                    Callable<V> eval = () -> c.compute(arg);
                    FutureTask<V> ft = new FutureTask<V>(eval);
                    f = cache.putIfAbsent(arg, ft);// 相比3的变化. 将空检测和放入,打包成一个原子操作.
                    if (f == null) {
                        f = ft;// 如果原来没有,待会儿要取这次算的值.
                        ft.run();
                    }
                }
                try {
                    return f.get();
                } catch (CancellationException e) {
                    cache.remove(arg, f);
                } catch (ExecutionException e) {
                    throw TestFutureTask.launderThrowable(e.getCause());
                }
            }
        }
    }
}
