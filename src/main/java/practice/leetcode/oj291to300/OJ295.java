package practice.leetcode.oj291to300;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jiuzhoumu on 2018/2/18.
 */
public class OJ295 {
    public static class MedianFinder {
        private Comparator<Integer> bigC = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        };

        private PriorityQueue<Integer> p1 = new PriorityQueue<>(bigC);//大顶堆
        private PriorityQueue<Integer> p2 = new PriorityQueue<>();//小顶堆

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (p2.size() == 0) {
                if (p1.size() == 0) {
                    p1.offer(num);
                    return;
                } else {
                    p1.offer(num);
                    p2.offer(p1.poll());
                    return;
                }
            }
            Integer b = p2.peek();
            if (p1.size() == p2.size()) {
                if (num > b) {
                    p2.offer(num);
                    p1.offer(p2.poll());
                } else {
                    p1.offer(num);
                }
            } else if (p1.size() > p2.size()) {
                if (num > b) {
                    p2.offer(num);
                } else {
                    p1.offer(num);
                    p2.offer(p1.poll());
                }
            }
        }

        public double findMedian() {

            if (p1.size() == p2.size()) {
                return ((double)p1.peek() + p2.peek()) / 2;
            } else {
                return p1.peek();
            }

        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());

    }
}
