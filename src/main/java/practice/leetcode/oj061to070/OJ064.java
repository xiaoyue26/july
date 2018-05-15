package practice.leetcode.oj061to070;

/**
 * Created by xiaoyue26 on 17/12/1.
 */
public class OJ064 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
                }
            }
        }


        return dp[n - 1];
    }

    public static void main(String[] args) {
        OJ064 obj = new OJ064();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(obj.minPathSum(grid));
    }
}
