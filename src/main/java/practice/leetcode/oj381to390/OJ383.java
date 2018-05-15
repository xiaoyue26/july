package practice.leetcode.oj381to390;

/**
 * @author xiaoyue26
 */
public class OJ383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int count[] = new int[26];
        char[] chars = magazine.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        char[] ins = ransomNote.toCharArray();
        for (char i : ins) {
            count[i - 'a']--;
            if (count[i - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        OJ383 obj = new OJ383();
        System.out.println(obj.canConstruct("aa", "ab"));
        System.out.println(obj.canConstruct("aa", "aab"));
    }
}
