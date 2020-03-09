package practice.leetcode.oj001to010;

/**
 * Created by xiaoyue26 on 17/11/4.
 */
public class OJ010 {
    public boolean isMatch(String s, String p) {
        // 假设p不会有'**'的输入
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {// *匹配0次,p中去掉俩字符: 可以沿用上次的true
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {//如果前一个字符匹配
                        //情况分为: 匹配多次(留着接下来继续匹配),匹配1次,匹配0次.
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    } else {//p中前一个字符用不上: 匹配0次,直接把j中的两个字符都忽略.
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];// j相隔2
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        OJ010 obj = new OJ010();
        System.out.println(obj.isMatch("aa", "aa"));
        System.out.println(obj.isMatch("aa", "a*"));
        System.out.println(obj.isMatch("aa", ".*"));// * 0或多个前序 // . 一个
        System.out.println(obj.isMatch("aab", "c*a*b*"));

    }
}
