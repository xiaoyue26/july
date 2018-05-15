package practice.leetcode.oj321to330;

import practice.leetcode.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/*
 * 流程：
 * 1. 对于单个数组，贪心计算 dp(num1,1...k)，dp(num2,1...k)
 * 2. 对于两个数组，dp计算  max{
 *        dp(num1,0) + dp(num2,k)
 *       ,dp(num1,1) + dp(num2,k-1)
 *       ,dp(num1,2) + dp(num2,k-2)
 *       ...
 *       ,dp(num1,k) + dp(num2,0)
 * };
 * 其中这个+,不是直接相加，是特殊merge函数
 * */
public class OJ321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        List<List<Integer>> dp1 = new ArrayList<>(k);
        List<List<Integer>> dp2 = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            if (i < nums1.length) {
                dp1.add(maxNumber(nums1, i + 1));
            } else {
                dp1.add(null);
            }
            if (i < nums2.length) {
                dp2.add(maxNumber(nums2, i + 1));
            } else {
                dp2.add(null);
            }
        }

        List<Integer> max = dp1.get(k - 1);
        for (int i = 1; i < k; i++) {
            List<Integer> tmp = merge(dp1.get(i - 1), dp2.get(k - i - 1));
            max = getMax(max, tmp);
        }

        max = getMax(max, dp2.get(k - 1));
        for (int i = 0; i < res.length; i++) {
            res[i] = max.get(i);
        }
        return res;
    }

    private List<Integer> getMax(List<Integer> nums1, List<Integer> nums2) {
        if (nums1 == null) {
            return nums2;
        }
        if (nums2 == null) {
            return nums1;
        }
        if (nums1.size() > nums2.size()) {
            return nums1;
        }
        if (nums1.size() < nums2.size()) {
            return nums2;
        }
        for (int i = 0; i < nums1.size(); i++) {
            if (nums1.get(i) > nums2.get(i)) {
                return nums1;
            } else if (nums1.get(i) < nums2.get(i)) {
                return nums2;
            }
        }
        return nums1;
    }

    private List<Integer> merge(List<Integer> nums1, List<Integer> nums2) {
        if (nums1 == null) {
            return nums2;
        }
        if (nums2 == null) {
            return nums1;
        }

        List<Integer> res = new ArrayList<>(nums1.size() + nums2.size());
        int i = 0, j = 0;
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1.get(i) > nums2.get(j)) {
                res.add(nums1.get(i));
                ++i;
            } else if (nums1.get(i) < nums2.get(j)) {
                res.add(nums2.get(j));
                ++j;
            } else {// ==

            }
        }
        while (i < nums1.size()) {
            res.add(nums1.get(i));
            ++i;
        }
        while (j < nums2.size()) {
            res.add(nums2.get(j));
            ++j;
        }

        return res;
    }

    private List<Integer> maxNumber(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(k);
        int[] minIndex = new int[k];
        res.add(nums[0]);
        minIndex[0] = 0;
        for (int i = 1; i < k && i < nums.length; i++) {
            res.add(nums[i]);
            if (nums[i] < nums[minIndex[i - 1]]) {
                minIndex[i] = i;
            } else {
                minIndex[i] = minIndex[i - 1];
            }
        }

        for (int i = k; i < nums.length; i++) {
            if (res.get(minIndex[k - 1]) < nums[i]) {
                res.remove(minIndex[k - 1]);
                res.add(nums[i]);
                if (res.get(k - 1) < res.get(minIndex[k - 1])) {
                    minIndex[k - 1] = k - 1;
                } else {
                    minIndex[k - 1] = k - 2 >= 0 ? minIndex[k - 2] : 0;
                }
            } else if (minIndex[k - 1] < k - 1) { // 右半部分左移
                res.remove(minIndex[k - 1]);
                res.add(nums[i]);
                minIndex[0] = 0;
                for (int j = 1; j < k && j < nums.length; j++) {
                    if (res.get(j) < res.get(minIndex[j - 1])) {
                        minIndex[j] = j;
                    } else {
                        minIndex[j] = minIndex[j - 1];
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        OJ321 obj = new OJ321();
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

    }
}