package practice.leetcode.oj381to390;

/**
 * @author xiaoyue26
 */
public class OJ387 {
    public int firstUniqChar(String s) {
        char[] cs = s.toCharArray();
        int flag[] = new int[26];
        for (char c : cs) {
            flag[c - 'a']++;
        }
        for (int i = 0; i < cs.length; ++i) {
            char c = cs[i];
            if (flag[c - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        OJ387 obj = new OJ387();
        System.out.println(obj.firstUniqChar("leetcode")); // 0
        System.out.println(obj.firstUniqChar("loveleetcode")); // 2
    }
}
