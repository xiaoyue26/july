package practice.chapter3;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/9/25.
 */
@ThreadSafe
public class VolatileCachedTest {
    private volatile OneValueCache cache = new OneValueCache(null, null);

    public void service() {
        BigInteger i = new BigInteger(String.valueOf(128));
        BigInteger factors[] = null;//some value
        if (factors == null) {
            cache = new OneValueCache(i, factors);// 获取缓存值.
        }


    }

    @Immutable
    public static class OneValueCache {
        private final BigInteger lastNumber;
        private final BigInteger[] lastFactors;

        public OneValueCache(BigInteger i, BigInteger[] factors) {
            lastNumber = i;
            lastFactors = factors;
        }

        public BigInteger[] getFactors(BigInteger i) {
            if (lastNumber == null || !lastNumber.equals(i)) {
                return null;
            } else {
                return Arrays.copyOf(lastFactors, lastFactors.length);
            }
        }
    }
}
