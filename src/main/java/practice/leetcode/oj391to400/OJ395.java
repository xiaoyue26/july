package practice.leetcode.oj391to400;


/**
 * @author xiaoyue26
 * 在子串中出现超过k次。
 * 用最少出现次数的char分割一下，分治求解
 */
public class OJ395 {
    public int longestSubstring(String s, int k) {
        int[] counter = new int[26];
        char[] cs = s.toCharArray();
        int minCount = k;
        int minCountChar = -1;
        for (char c : cs) {
            counter[c - 'a']++;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                if (minCount > counter[i]) {
                    minCount = counter[i];
                    minCountChar = (i + 'a');
                }
            }
        }
        if (minCount >= k) {
            return s.length();
        } else {
            int maxLen = 0;
            char[] c = new char[]{(char) minCountChar};
            String[] rest = s.split(new String(c));
            for (String r : rest) {
                maxLen = Math.max(maxLen, longestSubstring(r, k));
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        OJ395 obj = new OJ395();
        System.out.println(obj.longestSubstring("aaabb", 3));
        System.out.println(obj.longestSubstring("ababbc", 2));
        System.out.println(obj.longestSubstring("ababacb", 3));
    }
}
