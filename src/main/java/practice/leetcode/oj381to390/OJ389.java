package practice.leetcode.oj381to390;

/**
 * @author xiaoyue26
 */
public class OJ389 {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        char[] cs1 = s.toCharArray();
        char[] cs2 = t.toCharArray();
        for (char c : cs1) {
            count[c - 'a'] += 1;
        }
        for (char c : cs2) {
            if (count[c - 'a'] == 0) {
                return c;
            }
            count[c - 'a']--;
        }
        return '1';
    }

    public static void main(String[] args) {
        OJ389 obj = new OJ389();
        System.out.println(obj.findTheDifference("abcd", "abcde"));
    }
}
