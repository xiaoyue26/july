package practice.leetcode.oj251to260;

import practice.leetcode.utils.PrintUtils;

/**
 * Created by xiaoyue26 on 18/2/8.
 */
public class OJ260 {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums;
        }
        int[] res = new int[]{0, 0};
        int tmp = 0;
        for (int num : nums) {
            tmp ^= num;
        }
        tmp = tmp - (tmp & (tmp - 1));
        for (int num : nums) {
            if ((num & tmp) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        OJ260 obj = new OJ260();
        PrintUtils.print(obj.singleNumber(new int[]{1, 2, 1, 3, 2, 5}));//3,5
    }
}
