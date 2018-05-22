package practice.leetcode.oj401to410;


import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author xiaoyue26
 */
public class ConcurrentLinkedQueue {
    private static class Node<E> {
        public Node(E e) {

        }

        public boolean casNext(Object o, Node<E> n) {
            return true;
        }
    }

    private Node tail;

    public <E> boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        Node<E> n = new Node(e);
        for (; ; ) {

            Node<E> t = tail;
            if (t.casNext(null, n) && casTail(t, n)) {
                return true;
            }
        }
    }

    private <E> boolean casTail(Node<E> t, Node<E> n) {
        return true;
    }


    public void test() {
        int t1 = 6;
        System.out.println(t1 != (t1 = 5)); // true
        System.out.println(t1);// 5

        int t2 = 5;
        System.out.println(t2 != (t2 = 5)); // false
        System.out.println(t2); // 5

        // 其实就等效于
        int t = 6;
        if (t != 6) {
            t = 6;
            //return true;
        } else {
            //return false;
        }
    }

    /*
        public boolean offer(E e) {
            if (e == null) {
                throw new NullPointerException();
            }
            final Node newNode = new Node<E>(e);

            for (Node<E> t = tail, p = t; ; ) {
                Node<E> q = p.next;
                if (q == null) {// 此时p是尾节点
                    if (p.casNext(null, newNode)) {// 在尾巴上连newNode
                        if (p != t) { // 如果tail已经远离newNode
                            casTail(t, newNode); // 尝试把tail改成newNode
                        }
                        return true;
                    }
                } else if (p == q) {// q!=null,p不是尾节点
                    // , 单线程情况下,p是永远不等于q的，如果p==q了，说明有别的线程改了，我们已经落后于时代了，赶紧更新一下:
                    // p = (t != (t = tail)) ? t : head;
                    if (t != tail) {
                        t = tail;
                        p = t;
                    } else {
                        p = head;
                    }


                } else {
                    // Check for tail updates after two hops.
                    // p = (p != t && t != (t = tail)) ? t : q;
                    if (t != tail) {
                        t = tail;// 更新t的值
                        if (p != t) {
                            p = t; // 更新p的值
                        } else {
                            p = q; //   提醒
                        }
                    } else {
                        p = q;
                    }

                }
            }
        }
    */
    public static void main(String[] args) {
        ConcurrentLinkedQueue obj = new ConcurrentLinkedQueue();
        obj.test();
        System.out.println("there");
        Queue<Integer> e = new java.util.concurrent.ConcurrentLinkedQueue<>();
    }
}
