package practice.leetcode.oj421to430;

import java.util.concurrent.atomic.AtomicStampedReference;

import practice.leetcode.oj421to430.AtomicIntegerFieldUpdaterTest.User;

/**
 * @author xiaoyue26
 */
public class AtomicStampedReferenceTest {
    private static void test() {
        AtomicIntegerFieldUpdaterTest.User u1 = new User("123", 1);
        AtomicStampedReference<User> b = new AtomicStampedReference<>(u1, 1);
        AtomicStampedReference<Integer> a = new AtomicStampedReference<>(1, 1);
        a.compareAndSet(1, 2, 1, (int) (System.currentTimeMillis() / 1000));
        System.out.println(a.getReference());
        System.out.println(a.getStamp());


    }


    public static void main(String[] args) {
        test();
    }
}
