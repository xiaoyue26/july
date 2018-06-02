package practice.leetcode.oj421to430;

/**
 * @author xiaoyue26
 */
public class OJ424_others {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {// 滑动窗口头部
                count[s.charAt(start) - 'A']--;// start
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        OJ424_others obj = new OJ424_others();
        System.out.println(obj.characterReplacement("ABAB", 2));//4
        System.out.println(obj.characterReplacement("AABABBA", 1));//4
        System.out.println(obj.characterReplacement("AABA", 0));//2
    }
}
