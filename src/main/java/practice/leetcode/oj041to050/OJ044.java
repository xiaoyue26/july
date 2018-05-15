package practice.leetcode.oj041to050;

/**
 * Created by xiaoyue26 on 17/11/22.
 */
public class OJ044 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < p.length() + 1; ++j) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 1]) {
                dp[0][j] = true;
            }
        }
        char cs, cp;
        for (int j = 1; j < p.length() + 1; j++) {

            for (int i = 1; i < s.length() + 1; i++) {
                cs = s.charAt(i - 1);
                cp = p.charAt(j - 1);
                if (cp == '*') {// 匹配0,1,2及以上次
                    // 0次: dp[i][j-1]
                    // 1次: dp[i-1][j-1]
                    // 2次及以上: dp[i-1][j] 或者 dp[i-2][j]...
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i-1][j];
                } else if (cp == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (cp == cs) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }


        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        OJ044 obj = new OJ044();
        String s = "aa";
        String p = "a";

        System.out.println(obj.isMatch(s, p));//false
        System.out.println(obj.isMatch("aa", "aa"));//true
        System.out.println(obj.isMatch("aaa", "aa"));//false
        System.out.println(obj.isMatch("aa", "*"));// true
        System.out.println(obj.isMatch("aa", "a*"));//true
        System.out.println(obj.isMatch("ab", "?*"));//true
        System.out.println(obj.isMatch("aab", "c*a*b*"));//false
    }
}
