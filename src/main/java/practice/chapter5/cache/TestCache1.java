package practice.chapter5.cache;

import javax.annotation.concurrent.GuardedBy;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 17/10/16.
 */
public class TestCache1 {// 完全同步. 性能低.

    public interface Computable<A, V> {
        V compute(A arg) throws InterruptedException;
    }

    public class ExpensiveFunction implements Computable<String, BigInteger> {

        @Override
        public BigInteger compute(String arg) throws InterruptedException {
            return new BigInteger(arg);
        }
    }

    public class Memoizer1<A, V> implements Computable<A, V> {
        @GuardedBy("this")
        private final Map<A, V> cache = new HashMap<>();
        private final Computable<A, V> c;

        public Memoizer1(Computable<A, V> c) {
            this.c = c;
        }

        @Override
        public synchronized V compute(final A arg) throws InterruptedException {
            V result = cache.get(arg);
            if (result == null) {
                result = c.compute(arg);
                cache.put(arg, result);
            }
            return result;
        }
    }


}
