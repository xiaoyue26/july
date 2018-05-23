package practice.leetcode.oj411to420;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xiaoyue26
 */
public class RandomTest {
    private final AtomicLong seed;
    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;

    private static long initialScramble(long seed) {
        return (seed ^ multiplier) & mask;
    }

    public RandomTest(long seed) {
        this.seed = new AtomicLong(initialScramble(seed));
    }

    public void test() {
        Random random = new Random();
        random.nextInt();
        random.nextInt(100);
    }

    protected int next(int bits) {
        long oldseed, nextseed;
        AtomicLong seed = this.seed;
        do {
            oldseed = seed.get();
            nextseed = (oldseed * multiplier + addend) & mask;
        } while (!seed.compareAndSet(oldseed, nextseed));
        return (int) (nextseed >>> (48 - bits));
    }

    public static void main(String[] args) {
        RandomTest obj = new RandomTest(1);
        obj.test();
        System.out.println("there");
    }
}
