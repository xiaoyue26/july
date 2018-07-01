package practice.leetcode.oj451to460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author xiaoyue26
 */
public class OJ460 {
    public static class LFUCache {
        private Node head;
        private final int capacity;
        private final Map<Integer, Integer> valueMap;
        private final Map<Integer, Node> nodeMap;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            valueMap = new HashMap<>();
            nodeMap = new HashMap<>();
            head = null;
        }

        public int get(int key) {
            if (valueMap.containsKey(key)) {
                increaseCount(key);
                return valueMap.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            if (valueMap.containsKey(key)) {// 刷新
                valueMap.put(key, value);
            } else {
                if (valueMap.size() < capacity) {
                    valueMap.put(key, value);
                } else {
                    removeOld();
                    valueMap.put(key, value);
                }
                addToHead(key);// 更新nodeMap和head,可以优化为初始count为1
            }
            increaseCount(key);// 增加访问量
        }

        private void addToHead(int key) {
            if (head == null) {
                head = new Node(0);// 初始访问量0
                head.keys.add(key);
            } else if (head.count > 0) {
                Node node = new Node(0);// 初始访问量0
                node.keys.add(key);
                node.next = head;
                head.prev = node;
                head = node;
            } else {
                head.keys.add(key);
            }
            nodeMap.put(key, head);// 更新nodeMap
        }

        private void increaseCount(int key) {
            Node node = nodeMap.get(key);
            node.keys.remove(key);

            if (node.next == null) {// 没next创造next
                node.next = new Node(node.count + 1);
                node.next.prev = node;
                node.next.keys.add(key);
            } else if (node.next.count == node.count + 1) {// 对的next
                node.next.keys.add(key);
            } else {// 不对的next,创造对的next
                Node tmp = new Node(node.count + 1);
                tmp.keys.add(key);
                tmp.prev = node;
                tmp.next = node.next;
                node.next.prev = tmp;
                node.next = tmp;
            }

            nodeMap.put(key, node.next);// 刷新key,Node映射
            if (node.keys.size() == 0) remove(node);
        }

        private void removeOld() {
            if (head == null) return;
            int old = 0;
            for (int n : head.keys) {// 移除访问量最少的,且最先插入的
                old = n;
                break;
            }
            head.keys.remove(old);
            if (head.keys.size() == 0) remove(head);
            nodeMap.remove(old);
            valueMap.remove(old);
        }

        private void remove(Node node) {
            if (node.prev == null) {//移除head的话,要更新head
                head = node.next;
            } else {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }

        class Node {
            public int count;
            public LinkedHashSet<Integer> keys;
            public Node prev, next;

            public Node(int count) {
                this.count = count;
                keys = new LinkedHashSet<>();// 会自动按插入顺序排序
                // LinkedHashMap accessOrder 默认值false
                // accessOrder true: 按访问顺序排序
                // accessOrder false:按插入顺序排序
                prev = next = null;
            }
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}