package practice.leetcode.oj231to240;

import practice.leetcode.utils.PrintUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xiaoyue26 on 18/2/6.
 */
public class OJ239 {
    public int[] maxSlidingWindow(int[] num, int k) {
        if (num == null || k <= 0) {
            return new int[0];
        }
        int[] res = new int[num.length - k + 1];
        int ri = 0;
        // 存index
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            // 删队首的,超出范围的index
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.pollFirst();
            }
            // 从队尾开始删比a[i]小的元素的index(这些index永远不会上位了)
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
                deque.pollLast();
            }
            // 存index
            deque.offerLast(i);
            if (i >= k - 1) {// 确保窗口大小达到k
                res[ri++] = num[deque.peekFirst()];//peek
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OJ239 obj = new OJ239();
        PrintUtils.print(obj.maxSlidingWindow(new int[]{
                        1, 3, -1, -3, 5, 3, 6, 7
                }
                , 3));
    }
}
