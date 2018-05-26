package practice.leetcode.oj411to420;

/**
 * @author xiaoyue26
 * 反而比我的计数排序dfs慢
 * ,XD
 * ,可见dp也不一定优越
 */
public class OJ416_dp {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        boolean dp[][] = new boolean[nums.length][sum + 1];
        int curSum = nums[0];
        dp[0][0] = true;
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= curSum; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                    dp[i][j + nums[i]] = true;
                }

            }
            curSum += nums[i];
        }


        return dp[nums.length - 1][target];
    }

    public static void main(String[] args) {
        OJ416_dp obj = new OJ416_dp();
        System.out.println(obj.canPartition(new int[]{
                1, 5, 11, 5
        }));
        System.out.println(obj.canPartition(new int[]{
                1, 2, 3, 5
        }));
        System.out.println(obj.canPartition(new int[]{
                1, 1
        }));
    }
}
