package practice.leetcode.oj001to010;


/**
 * Created by xiaoyue26 on 17/11/3.
 */
public class OJ005 {
    // 简单二维dp:
    public String longestPalindrome_simpleDp(String s) {
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

    // 马拉车算法,一维dp搞定,类似于kmp的思想:
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // 1. create #a#, 一定为奇数的数组, 大前提是输入中永远不会出现#号
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }
        // 2. 计算radix数组: radix[i]: 以i为中心的最长回文半径(含中心);回文串长度一定为奇数,半径可以为偶数
        int radix[] = new int[sb.length()];
        int maxRight = 0; // 当前遇到的回文串能达到的最右边;
        int center = 0; //  上述回文串的中心;
        for (int i = 1; i < sb.length(); i++) {
            // 2.1 设定radix[i]初始值:
            int left = 2 * center - maxRight;
            if (i > center && i < maxRight) {
                int j = left + (maxRight - i);
                radix[i] = Math.min(radix[j], maxRight - i + 1);
            } else {
                radix[i] = 1;
            }
            // 2.2 拓展radix[i]:
            while (i - radix[i] >= 0 && i + radix[i] < sb.length() && (sb.charAt(i - radix[i]) == sb.charAt(i + radix[i]))) {
                radix[i]++;
            }
            // 2.3 更新center,maxRight:
            if (i + radix[i] - 1 > maxRight) {
                maxRight = i + radix[i] - 1;
                center = i;
            }


        }
        // 3. 从radix[]得到回文串
        int maxIndex = 0;
        int maxRadix = 1;
        for (int i = 0; i < radix.length; i++) {
            if (radix[i] > maxRadix) {
                maxRadix = radix[i];
                maxIndex = i;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = maxIndex - maxRadix + 1; i < maxIndex + maxRadix - 1; i++) {
            if (i % 2 == 1) {
                res.append(sb.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        OJ005 obj = new OJ005();
        String s = "babad";
        String res = obj.longestPalindrome(s);
        System.out.println(res);
        System.out.println(obj.longestPalindrome("babad")); // bad
        System.out.println(obj.longestPalindrome("cbbd")); // bb
        System.out.println(obj.longestPalindrome("aaaa")); // aaaa
        System.out.println(obj.longestPalindrome("a")); // a
        System.out.println(obj.longestPalindrome("")); // ""
        System.out.println(obj.longestPalindrome(null)); // ""
    }
}
