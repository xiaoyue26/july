package practice.leetcode.oj071to080;

import practice.leetcode.utils.PrintUtils;

/**
 * Created by xiaoyue26 on 17/12/5.
 * 最多可以重复2次.
 * 1,1,1 => 1,1
 */
public class OJ080 {
    public int removeDuplicates(int[] nums) {// sorted num
        int len = 2;
        int tail = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[tail - 1]) {
                nums[++tail] = nums[i];
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        OJ080 obj = new OJ080();
        int nums[] = {
                1, 1, 1, 2, 2, 3
        };
        System.out.println(obj.removeDuplicates(nums));
        PrintUtils.print(nums);
    }
}
