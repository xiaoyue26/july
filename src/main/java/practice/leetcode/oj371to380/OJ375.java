package practice.leetcode.oj371to380;

/**
 * @author xiaoyue26
 * xi = result_when_pick_k = k + max{dp([i,k-1]), dp([k+1, j])}
 * dp[i,j] = min{xi, … ,xj}
 */
public class OJ375 {


    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i > 0; i--) {
                int min_i_j = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int localMax = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    min_i_j = Math.min(min_i_j, localMax);
                }
                dp[i][j] = i + 1 == j ? i : min_i_j;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        OJ375 obj = new OJ375();
        System.out.println(obj.getMoneyAmount(10));//16
        System.out.println(obj.getMoneyAmount(1));//0
        System.out.println(obj.getMoneyAmount(4));//4
    }
}
