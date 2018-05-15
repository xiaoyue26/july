package practice.leetcode.oj091to100;

/**
 * Created by xiaoyue26 on 17/12/13.
 */
public class OJ096 {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        OJ096 obj = new OJ096();
        System.out.println(obj.numTrees(3));
    }
}
