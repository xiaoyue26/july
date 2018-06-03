package practice.leetcode.oj431to440;


import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoyue26
 */
public class OJ432 {
    public static class AllOne {
        private class Node {
            public String key;
            public int value;
            public Node next;
            public Node pre;

            public Node(String key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Node dumpHead;
        private Node tail;
        private final Map<String, Node> nodeMap;


        public AllOne() {
            dumpHead = new Node(null, -1);// dumpHead
            tail = dumpHead.next;
            nodeMap = new HashMap<>();
        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            Node p;
            if (nodeMap.containsKey(key)) {// try p.next
                p = nodeMap.get(key);
                p.value++;
                while (p.next != null && p.value > p.next.value) {
                    inc(p);
                }
            } else { // insert dumpHead.next:
                p = new Node(key, 1);
                p.next = dumpHead.next;
                if (dumpHead.next != null) {
                    dumpHead.next.pre = p;
                }
                dumpHead.next = p;
                p.pre = dumpHead;
                nodeMap.put(key, p);
            }
            if (p.next == null) {
                tail = p;
            }
        }

        private void inc(Node p) {
            Node q = p.next;
            Node pre = p.pre;
            p.pre = q;
            pre.next = q;
            q.pre = pre;
            p.next = q.next;
            if (q.next != null) {
                q.next.pre = p;
            }
            q.next = p;
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {
            Node p;
            if (nodeMap.containsKey(key)) {
                p = nodeMap.get(key);
                p.value--;

                while (p.pre != dumpHead && p.value < p.pre.value) {
                    if (tail == p) {
                        tail = p.pre;
                    }
                    dec(p);
                }
                if (p.value == 0) {
                    nodeMap.remove(key);
                    dumpHead.next = p.next;
                    if (p.next != null) {
                        p.next.pre = dumpHead;
                    }
                    p.pre = null;
                    p.next = null;
                }

            }
        }

        private void dec(Node q) {
            Node p = q.pre;
            Node pre = p.pre;
            p.pre = q;
            pre.next = q;
            q.pre = pre;
            p.next = q.next;
            if (q.next != null) {
                q.next.pre = p;
            }
            q.next = p;
        }


        public String getMaxKey() {
            if (tail == null) {
                return "";
            }
            return tail.key;

        }

        public String getMinKey() {

            if (dumpHead.next == null) {
                return "";
            }
            return dumpHead.next.key;
        }
    }

    public static void print(AllOne.Node dump) {
        while (dump != null) {
            System.out.print(dump.key);
            System.out.print(" ");
            dump = dump.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        AllOne obj = new AllOne();
        obj.inc("hello");
        obj.inc("goodbye");
        obj.inc("hello");
        obj.inc("hello");
        System.out.println(obj.getMaxKey());
        obj.inc("leet");
        obj.inc("code");
        obj.inc("leet");
        obj.dec("hello");
        // print(obj.dumpHead);
        obj.inc("leet");
        obj.inc("code");
        obj.inc("code");
        System.out.println(obj.getMaxKey());
    }
}
//["AllOne","inc","inc","inc","inc","getMaxKey","inc","inc","inc","dec","inc","inc","inc","getMaxKey"]
//[[],["hello"],["goodbye"],["hello"],["hello"],[],["leet"],["code"],["leet"],["hello"],["leet"],["code"],["code"],[]]