package practice.leetcode.oj311to320;

/* 倒序分析，假设i是最后一个戳破的气球。
 *  res= 1*nums[i]*1 + maxCoins(left) + maxCoins(right)
 *
 *  dp[i,j] = Max{
 *         nums[k]+dp[i,k-1]+dp[k+1,j]
 *  }
 *  (k->[i,j])
 * */
public class OJ312 {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int w = 0; w <= len - 1; w++) {// 区间长度为w,从小区间开始算。
            for (int i = 0; i + w <= len - 1; i++) {
                int j = i + w;
                for (int k = i; k <= j; k++) {// k最后破
                    int leftPart = k == i ? 0 : dp[i][k - 1];
                    int rightPart = k == j ? 0 : dp[k + 1][j];
                    int left = i <= 0 ? 1 : nums[i - 1];
                    int right = j >= len - 1 ? 1 : nums[j + 1];
                    int curPart = left * nums[k] * right;
                    dp[i][j] = Math.max(dp[i][j], leftPart + curPart + rightPart);
                }
            }
        }
        return dp[0][len - 1];
    }

    public int maxCoins_others(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = nums.length;
        for (int i = 0; i < iNums.length; i++) {
            nums[i + 1] = iNums[i];
        }
        nums[0] = nums[n - 1] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i) {
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right]
                                    + dp[left][i]
                                    + dp[i][right]);
                }
            }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        OJ312 obj = new OJ312();
        System.out.println(obj.maxCoins(new int[]{
                3, 1, 5, 8//167
        }));
    }
}