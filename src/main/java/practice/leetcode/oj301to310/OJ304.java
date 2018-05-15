package practice.leetcode.oj301to310;

/**
 * Created by xiaoyue26 on 18/2/22.
 */
public class OJ304 {
    static class NumMatrix {
        private int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            dp = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i <= matrix.length; i++) {
                dp[i][0] = 0;
            }
            for (int j = 0; j <= matrix[0].length; j++) {
                dp[0][j] = 0;
            }
            for (int i = 1; i <= matrix.length; i++) {
                //dp[i][1] = matrix[i - 1][0] + dp[i - 1][1];
                for (int j = 1; j <= matrix[0].length; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (dp.length == 1 || dp[0].length == 1) {
                return 0;
            }
            return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row2 + 1][col1] - dp[row1][col2 + 1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));// 8
        System.out.println(obj.sumRegion(1, 1, 2, 2));// 11
        System.out.println(obj.sumRegion(1, 2, 2, 4));// 12
    }
}
