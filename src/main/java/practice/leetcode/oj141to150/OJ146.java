package practice.leetcode.oj141to150;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 18/1/1.
 */
public class OJ146 {
    public static class LRUCache {

        class DNode {
            int key;
            int value;
            DNode left = null;
            DNode right = null;


            public DNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Map<Integer, DNode> map;
        int maxLen;
        int curLen = 0;
        DNode head = null;
        DNode tail = null;

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            this.maxLen = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                DNode node = map.get(key);
                moveToHead(node);
                return node.value;
            } else {
                return -1;
            }
        }

        private void moveToHead(DNode node) {
            if (node != head) {
                if (node == tail) {
                    tail = node.left;
                }
                node.left.right = node.right;
                if (node.right != null) {
                    node.right.left = node.left;
                }
                node.left = null;
                node.right = head;
                if (head != null) {
                    head.left = node;
                }
                head = node;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                DNode node = map.get(key);
                node.value = value;
                moveToHead(node);

            } else {
                DNode cur = new DNode(key, value);
                cur.right = head;
                if (head != null) {
                    head.left = cur;
                }
                head = cur;
                if (curLen >= maxLen) { // remove tail
                    removeNode(tail);
                    curLen--;
                }
                curLen++;
                if (curLen == 1) {
                    tail = head;
                }
                map.put(key, cur);
            }
        }

        private void removeNode(DNode node) {
            if (node != null) {
                map.remove(node.key);
                tail = node.left;
                tail.right = null;
            }
        }

    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(2, 3);
        System.out.println(cache.get(2)); // 3
        System.out.println(cache.get(1)); // 1
        cache.put(3, 3);// remove 2
        System.out.println(cache.get(2));// -1
        cache.put(4, 4);// remove 1
        System.out.println(cache.get(1));// -1
        System.out.println(cache.get(3));// 3
        System.out.println(cache.get(4));// 4
    }
}
