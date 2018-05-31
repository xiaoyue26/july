package practice.leetcode.oj421to430;

import java.util.concurrent.atomic.AtomicStampedReference;

import practice.leetcode.oj421to430.AtomicIntegerFieldUpdaterTest.User;

/**
 * @author xiaoyue26
 */
public class AtomicStampedReferenceTest {
    AtomicIntegerFieldUpdaterTest.User u1 = new User("123", 1);
    AtomicStampedReference<Integer> a = new AtomicStampedReference<>(1, 1);
    AtomicStampedReference<User> b = new AtomicStampedReference<>(u1, 1);

    public static void main(String[] args) {
        AtomicStampedReferenceTest obj = new AtomicStampedReferenceTest();

        System.out.println("there");
    }
}
