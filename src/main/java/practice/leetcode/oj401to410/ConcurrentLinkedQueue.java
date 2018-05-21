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

    }

    public static void main(String[] args) {
        ConcurrentLinkedQueue obj = new ConcurrentLinkedQueue();
        obj.test();
        System.out.println("there");
        Queue<Integer>e=new java.util.concurrent.ConcurrentLinkedQueue<>();
    }
}
