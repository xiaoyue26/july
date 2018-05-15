package practice.leetcode.oj111to120;

/**
 * Created by xiaoyue26 on 17/12/19.
 * s删一些字符等于t. 有几种可能.
 */
public class OJ115 {
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        if (s.length() == t.length()) {
            return s.equals(t) ? 1 : 0;
        }
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
            if (i >= t.length()) {

            } else {
                dp[i][i] = s.substring(0, i).equals(t.substring(0, i)) ? 1 : 0;
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j <= i && j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        OJ115 obj = new OJ115();
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(obj.numDistinct(s, t));
        System.out.println(obj.numDistinct("ccc", "c"));
    }
}
