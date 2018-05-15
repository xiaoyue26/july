package practice.leetcode.oj321to330;

/**
 * dfs+回溯
 * dp[i][j]: 以i,j为起点的最长长度
 * dp[i][j]=max {dp[?][?]+1} // 由于一直是增大，不会相等，因此不会出现"贪食蛇咬到自己"的情况
 * <p>
 * 为了利用dp数组，从大到小扫描?
 * 不必, 每dfs一个起点,记录整条线的dp值即可.
 */
public class OJ329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length < 1) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        //boolean[][] visited = new boolean[m][n];
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, i, j, dp, Integer.MIN_VALUE);
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;

    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp, int preNum) {
        if (inValid(matrix, i, j) || matrix[i][j] <= preNum) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        dp[i][j] = Math.max(dp[i][j], dfs(matrix, i + 1, j, dp, matrix[i][j]) + 1);
        dp[i][j] = Math.max(dp[i][j], dfs(matrix, i - 1, j, dp, matrix[i][j]) + 1);
        dp[i][j] = Math.max(dp[i][j], dfs(matrix, i, j - 1, dp, matrix[i][j]) + 1);
        dp[i][j] = Math.max(dp[i][j], dfs(matrix, i, j + 1, dp, matrix[i][j]) + 1);
        return dp[i][j];
    }

    private boolean inValid(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        OJ329 obj = new OJ329();
        System.out.println(obj.longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        }));//4 : 1,2,6,9
        System.out.println(obj.longestIncreasingPath(new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        }));//4 : 3,4,5,6
    }
}