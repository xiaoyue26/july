package practice.chapter5.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xiaoyue26 on 17/10/16.
 * 新的需求:
 * 场景: T1需要数据d1,但没有,因此开始算;
 * T2也需要数据d1,但没有;但T1还在算,T2不知道,也开始算.
 * <p>
 * 需求: 避免重复计算. 让T2只是干等,不要重复算.
 */
public class TestCache2 {// 简单得用concurrentMap代替MaP

    public class Memoizer2<A, V> implements TestCache1.Computable<A, V> {
        private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
        private final TestCache1.Computable<A, V> c;

        public Memoizer2(TestCache1.Computable<A, V> c) {
            this.c = c;
        }

        @Override
        public V compute(final A arg) throws InterruptedException {
            V result = cache.get(arg);
            if (result == null) {
                result = c.compute(arg);
                cache.put(arg, result);
            }
            return result;
        }
    }
}
