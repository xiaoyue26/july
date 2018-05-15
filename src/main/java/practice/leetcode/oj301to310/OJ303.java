package practice.leetcode.oj301to310;

/**
 * Created by xiaoyue26 on 18/2/22.
 */
public class OJ303 {
    static class NumArray {
        private int dp[];

        public NumArray(int[] nums) {
            dp = new int[nums.length];
            if (nums.length == 0) {
                return;
            }
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = dp[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if (dp.length == 0) {
                return 0;
            }
            if (i == 0) {
                return dp[j];
            }
            return dp[j] - dp[i - 1];
        }
    }

    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{
                -2, 0, 3, -5, 2, -1
        });
        System.out.println(obj.sumRange(0, 2));// 1
        System.out.println(obj.sumRange(2, 5));// -1
        System.out.println(obj.sumRange(0, 5));// -3
    }
}
