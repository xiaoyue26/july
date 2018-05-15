package practice.leetcode.oj221to230;

/**
 * Created by xiaoyue26 on 18/1/26.
 * 必须是正方形.
 */
public class OJ221 {
    // dp[i,j] : 以(i,j)为右下角的正方形边长.
    // dp[i,j] = min{ dp[i-1,j],dp[i,j-1],dp[i-1,j-1] } + 1
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxLen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1' || matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        OJ221 obj = new OJ221();
        System.out.println(obj.maximalSquare(new char[][]{
                {1, 0, 1, 0, 0}
                , {1, 0, 1, 1, 1}
                , {1, 1, 1, 1, 1}
                , {1, 0, 0, 1, 0}
        }));//  4
    }
}
