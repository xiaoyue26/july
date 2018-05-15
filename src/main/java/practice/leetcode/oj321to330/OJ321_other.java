package practice.leetcode.oj321to330;

import practice.leetcode.utils.PrintUtils;

import java.util.Deque;
import java.util.LinkedList;

public class OJ321_other {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    /**
     * 手动实现栈，而且极度geek的版本:
     */
    public int[] maxArray_difficult(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i > k - j && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }

    /**
     *  使用stack的版本，比较简单
     * */
    private int[] maxArray(int[] nums, int len) {
        Deque<Integer> stack = new LinkedList<>(); // 条件允许的话，最小的元素在栈顶
        for (int i = 0; i < nums.length; i++) {
            while (nums.length - i > len - stack.size() // 剩余的元素数量>需要的元素数量 (还有淘汰的空间)
                    && !stack.isEmpty() //  栈不为空
                    && stack.peek() < nums[i]) { //  有大的进来
                stack.pop(); // 淘汰一个最小的
            }
            if (stack.size() < len) {
                stack.push(nums[i]);
            }
        }
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            result[i] = stack.pop(); // 反转栈
        }
        return result;
    }


    public static void main(String[] args) {
        OJ321_other obj = new OJ321_other();
        PrintUtils.print(obj.maxNumber(
                new int[]{3, 4, 6, 5},
                new int[]{9, 1, 2, 5, 8, 3}
                , 5));
        // 9,8,6,5,3
        PrintUtils.print(obj.maxNumber(
                new int[]{6, 7},
                new int[]{6, 0, 4}
                , 5));
        // 6,7,6,0,4
        PrintUtils.print(obj.maxNumber(
                new int[]{3, 9},
                new int[]{8, 9}
                , 3));
        // 9,8,9

        PrintUtils.print(obj.maxNumber(
                new int[]{5, 5, 1},
                new int[]{4, 0, 1}
                , 3));
        // 5,5,4
    }
}