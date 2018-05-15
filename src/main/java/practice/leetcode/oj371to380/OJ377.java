package practice.leetcode.oj371to380;

import java.util.Arrays;

/**
 * @author 可以重复使用
 * 排列组合的数量
 */
public class OJ377 {
    public int combinationSum4_way2(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }

    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }

    public static void main(String[] args) {
        OJ377 obj = new OJ377();
        System.out.println(obj.combinationSum4(new int[]{
                1, 2, 3
        }, 4));// 7 // 1,1,1,1; 1,1,2; 1,2,1 ...
    }
}
