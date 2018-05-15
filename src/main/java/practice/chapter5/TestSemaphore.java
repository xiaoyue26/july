package practice.chapter5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by xiaoyue26 on 17/10/15.
 */
public class TestSemaphore {//测试信号量
    public static class BoundedHashSet<T> {
        private final Set<T> set;
        private final Semaphore sem;

        public BoundedHashSet(int bound) {
            set = Collections.synchronizedSet(new HashSet<T>());//创建一个全加锁(同步)的Set
            sem = new Semaphore(bound);// 信号量(计数器)里存放大小.
        }

        public boolean add(T o) throws InterruptedException {// 根据业务具体考虑是否加finally release
            sem.acquire();// P  (P/V操作的P)
            boolean wasAdded = set.add(o);
            if (!wasAdded) {//如果其实是重复添加,并不消耗空间
                sem.release();//V
            }
            return wasAdded;
        }

        public boolean remove(T o) {
            boolean wasRemoved = set.remove(o);
            if (wasRemoved) {// 如果没有这个元素,其实可用空间并没有增加.
                sem.release();
            }
            return wasRemoved;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        BoundedHashSet<Integer> set = new BoundedHashSet<>(2);
        set.add(10);
        set.add(10);
        set.add(11);
        set.remove(11);// 注释的话就只能到here
        System.out.println("here");
        set.add(123);
    }
}
