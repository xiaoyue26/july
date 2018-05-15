package practice.leetcode.oj341to350;


import java.util.*;

/**
 * @author xiaoyue26
 * 用最小堆
 * 18ms
 */
public class OJ347 {
    public static class Node {
        public int num;
        public int times;

        public Node(int num, int times) {
            this.num = num;
            this.times = times;
        }

        public static class NodeComparator implements Comparator<Node> {

            @Override
            public int compare(Node o1, Node o2) {
                return o2.times - o1.times;
            }

            @Override
            public boolean equals(Object obj) {
                return obj.equals(this);
            }

        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(k);
        Queue<Node> queue = new PriorityQueue<>(new Node.NodeComparator());
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Node n = map.get(nums[i]);
            if (n == null) {
                map.put(nums[i], new Node(nums[i],1));
            } else {
                n.times++;
            }
        }
        for (Map.Entry<Integer, Node> e : map.entrySet()) {
            queue.offer(e.getValue());
        }
        for (int i = 0; i <k ; i++) {
            res.add(queue.poll().num);
        }
        return res;
    }

    public static void main(String[] args) {
        OJ347 obj = new OJ347();
        System.out.println(obj.topKFrequent(new int[]{
                1, 1, 1, 2, 2, 3
        }, 2));// 1,2
    }
}
