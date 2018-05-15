package practice.leetcode.oj281to290;

import practice.leetcode.utils.PrintUtils;

/**
 * Created by jiuzhoumu on 2018/2/15.
 */
public class OJ283 {
    public void moveZeroes(int[] nums) {
        int tail = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[tail++] = num;
            }
        }
        while (tail < nums.length) {
            nums[tail++] = 0;
        }

    }

    public static void main(String[] args) {
        OJ283 obj = new OJ283();
        int[] nums = new int[]{
                0, 1, 0, 3, 12
        };
        obj.moveZeroes(nums);
        PrintUtils.print(nums);
    }
}
