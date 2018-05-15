package practice.leetcode.oj161to170;

import practice.leetcode.utils.PrintUtils;

/**
 * Created by xiaoyue26 on 18/1/7.
 * 有序的可以用夹逼
 */
public class OJ167_new {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int left = 0, right = nums.length - 1;
        long tmp;
        while (left < right) {
            tmp = nums[left] + nums[right];
            if (tmp == target) {
                return new int[]{left + 1, right + 1};
            }
            if (tmp < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        OJ167_new obj = new OJ167_new();
        int nums[] = new int[]{2, 7, 11, 15};
        PrintUtils.print(obj.twoSum(nums, 9));//1,2
        PrintUtils.print(obj.twoSum(new int[]{2, 3, 4}, 6));//1,3
        PrintUtils.print(obj.twoSum(new int[]{0, 0, 3, 4}, 0));//1,3
    }


}
