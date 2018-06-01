package practice.leetcode.oj421to430;

/**
 * @author xiaoyue26
 */
public class OJ424 {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int begin = 0, end = 0, gap = 0;
        int maxLen = 1;
        int nextBegin = 0;
        char[] chars = s.toCharArray();
        char pre = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == pre) {
                end = i;
            } else {
                if (gap < k) {
                    end = i;
                    gap += 1;
                    if (gap == 1) {
                        nextBegin = i;
                    }
                } else {
                    // store
                    maxLen = Math.max(end - begin + 1, maxLen);
                    //  change to next
                    if (nextBegin == begin) {
                        nextBegin = i;
                    }
                    begin = nextBegin;
                    end = begin;
                    gap = 0;
                    pre = chars[begin];
                    i = begin;
                }
            }
        }
        // deal final:
        int tmp = Math.min(chars.length, end - begin + 1 + k - gap);
        maxLen = Math.max(maxLen, tmp);


        return maxLen;
    }

    public static void main(String[] args) {
        OJ424 obj = new OJ424();
        System.out.println(obj.characterReplacement("ABAB", 2));//4
        System.out.println(obj.characterReplacement("AABABBA", 1));//4
        System.out.println(obj.characterReplacement("AABA", 0));//2
    }
}
