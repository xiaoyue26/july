package practice.leetcode.oj401to410;

public class OJ409 {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        boolean[] letters = new boolean[26 * 2];
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'a' && c <= 'z') {
                if (letters[c - 'a']) {
                    res += 2;
                    letters[c - 'a'] = false;
                } else {
                    letters[c - 'a'] = true;
                }
            } else {
                if (letters[c - 'A' + 26]) {
                    res += 2;
                    letters[c - 'A' + 26] = false;
                } else {
                    letters[c - 'A' + 26] = true;
                }
            }

        }
        if (chars.length > res) {
            res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        OJ409 obj = new OJ409();
        System.out.println(obj.longestPalindrome("abccccdd"));
        System.out.println(obj.longestPalindrome("aaaAaaaa"));
    }
}
