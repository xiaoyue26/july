package practice.leetcode.oj001to010;

/**
 * Created by xiaoyue26 on 17/11/5.
 */
public class OJ010_new {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // fill fisrt row 可以简化为: dp[0][j] = p.charAt(j) == '*' && dp[0][j - 2];
        for (int j = 1; j < p.length() + 1; j++) {
            int pj = j - 1;
            if (p.charAt(pj) == '*') { // 匹配0次. 与前一个p同归于尽
                dp[0][j] = dp[0][j - 2];
            } else {
                dp[0][j] = false;//可以省略
            }
        }
        // fill first col: 正好初始值就是false 可以省略
        /*for (int i = 1; i < s.length() + 1; i++) {
            dp[i][0] = false;
        }*/
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                int si = i - 1;
                int pj = j - 1;
                if (s.charAt(si) == p.charAt(pj) || p.charAt(pj) == '.') {// si与pj同归于尽
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(pj) == '*') {
                    if (s.charAt(si) == p.charAt(pj - 1) || p.charAt(pj - 1) == '.') {
                        dp[i][j] = dp[i][j - 1] // 此时*表示匹配1次,保留前一个p,自己消失;
                                || dp[i][j - 2]//此时*表示匹配0次, 与前一个p同归于尽;
                                || dp[i - 1][j]; // 此时*表示匹配2次及以上. s[0-i-1]与p[0-j]匹配
                    } else {
                        dp[i][j] = dp[i][j - 2];// 匹配0次.
                    }
                } else {
                    // 可以省略.
                    dp[i][j] = false;
                }
            }
        }


        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        OJ010_new obj = new OJ010_new();
        System.out.println(obj.isMatch("aa", "aa"));
        System.out.println(obj.isMatch("aa", "a*"));
        System.out.println(obj.isMatch("", ".*"));// * 0或多个前序 // . 一个
        System.out.println(obj.isMatch("aab", "c*a*b*"));
    }
}
