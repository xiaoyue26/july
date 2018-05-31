package practice.leetcode.oj421to430;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author xiaoyue26
 */
public class AtomicIntegerFieldUpdaterTest {

    private static AtomicIntegerFieldUpdater<User> a
            = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    public static class User {
        private final String name;
        public volatile int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

    }


    public static void main(String[] args) {
        User u1 = new User("mq", 10);
        System.out.println(a.getAndIncrement(u1));
        System.out.println(u1.age);

    }
}
