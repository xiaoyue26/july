package practice.leetcode.oj181to190;

import practice.leetcode.utils.PrintUtils;

import java.util.Arrays;
import java.util.Collections;


/**
 * Created by xiaoyue26 on 18/1/13.
 */
public class OJ189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length);
    }

    private void reverse(int[] nums, int left, int right) {
        if (nums == null) {
            return;
        }
        int i = Math.max(0, left);
        int j = Math.min(nums.length - 1, right);
        int tmp;
        while (i < j) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }

    }


    public static void main(String[] args) {
        OJ189 obj = new OJ189();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        obj.rotate(nums, 3);
        PrintUtils.print(nums);

    }
}
