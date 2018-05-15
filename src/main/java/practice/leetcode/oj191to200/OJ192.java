package practice.leetcode.oj191to200;

/**
 * Created by xiaoyue26 on 18/1/14.
 */
public class OJ192 {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];// dp[i],以i结尾的抢劫
        int max=0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Math.max(getDp(dp, i - 2) + nums[i]
                    , getDp(dp,i - 3) + nums[i]);
            max=Math.max(max,dp[i]);

        }

        return max;
    }

    private int getDp(int dp[], int i) {
        if (i >= 0 && i < dp.length) {
            return dp[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        OJ192 obj = new OJ192();
        System.out.println(obj.rob(new int[]{3, 1000, 1, 1, 1000, 9, 2}));
    }
}
