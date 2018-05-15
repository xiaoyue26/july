package practice.leetcode.oj001to010;


/**
 * Created by xiaoyue26 on 17/11/3.
 */
public class OJ005 {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int max = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j <= len - 1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 >= j) {// equal or next
                        dp[i][j] = true;
                    } else {// check inside
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        } else {
                            //dp[i][j] = false;
                        }
                    }
                    if (j - i + 1 > max && dp[i][j]) {
                        start = i;
                        max = j - i + 1;
                    }
                }

            }
        }
        return s.substring(start, start + max);

    }

    private String longestCommonString(String s1, String s2) {
        /*String s2 = StringUtils.reverse(s);
        return longestCommonString(s, s2);*/
        return s1;
    }

    public static void main(String[] args) {
        OJ005 obj = new OJ005();
        String s = "babad";
        String res = obj.longestPalindrome(s);
        System.out.println(res);
    }
}
