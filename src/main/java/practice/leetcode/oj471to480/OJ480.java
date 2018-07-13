package practice.leetcode.oj471to480;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class OJ480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0) {
            return new double[0];
        }
        Queue<Integer> maxHeap = new PriorityQueue<>(1000
                , Collections.reverseOrder());// 放的都是小的一半
        Queue<Integer> minHeap = new PriorityQueue<>();// 放的是大的一半
        boolean needDiv = false;
        if ((k & 1) == 0) {
            needDiv = true;
        }
        double res[] = new double[nums.length - k + 1];
        // deal first:
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {// keep minHeap no smaller
            maxHeap.add(minHeap.poll());
        }
        if (needDiv) {
            res[0] = ((double) maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            res[0] = minHeap.peek();
        }

        // deal rest:
        for (int i = 1; i < res.length; i++) {
            removeNum(nums[i - 1], minHeap, maxHeap);
            // minHeap.remove(nums[i - 1]);
            addNum(nums[i + k - 1], minHeap, maxHeap);
            if (needDiv) {
                res[i] = ((double) maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                res[i] = minHeap.peek();
            }

        }
        return res;
    }

    private void removeNum(int num, Queue<Integer> minHeap, Queue<Integer> maxHeap) {
        if (num > minHeap.peek() || maxHeap.size() == 0 || num > maxHeap.peek()) {
            minHeap.remove(num);
        } else {
            maxHeap.remove(num);
        }
        // adjust size:
        while (minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        while (maxHeap.size() < minHeap.size() - 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private void addNum(int num, Queue<Integer> minHeap, Queue<Integer> maxHeap) {
        if (minHeap.size() == 0) {
            minHeap.add(num);
        } else if (num >= minHeap.peek()) {
            minHeap.add(num);
        } else if (maxHeap.size() == 0) {
            maxHeap.add(num);
        } else if (num >= maxHeap.peek()) {
            minHeap.add(num);
        } else {
            minHeap.add(maxHeap.poll());
            maxHeap.add(num);
        }
        // adjust size:
        while (minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        while (maxHeap.size() < minHeap.size() - 1) {
            maxHeap.add(minHeap.poll());
        }
    }


    public static void main(String[] args) {
        OJ480 obj = new OJ480();
        double[] res = obj.medianSlidingWindow(new int[]{
                1, 3, -1, -3, 5, 3, 6, 7
        }, 1);//1,-1,-1,3,5,6
        for (double r : res) {
            System.out.println(r);
        }
    }
}
