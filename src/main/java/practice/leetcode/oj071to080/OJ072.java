package practice.leetcode.oj071to080;

/**
 * Created by xiaoyue26 on 17/12/2.
 * 插删改,3种元操作.
 */
public class OJ072 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word1.length() == 0) {
            return word1.length();
        }
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];//可以优化成一维数组
        dp[0][0] = 0;
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1] // update 0
                            , dp[i - 1][j] + 1//delete 1
                    );
                    dp[i][j] = Math.min(
                            dp[i][j]
                            , dp[i][j - 1] + 1//insert 1
                    );
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1] + 1// update 1
                            , dp[i - 1][j] + 1//delete 1
                    );
                    dp[i][j] = Math.min(
                            dp[i][j]
                            , dp[i][j - 1] + 1//insert 1
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        OJ072 obj = new OJ072();
        System.out.println(obj.minDistance("abc", "dfs"));
        System.out.println(obj.minDistance("abc", "acb"));
        System.out.println(obj.minDistance("abd", "dab"));
    }
}
