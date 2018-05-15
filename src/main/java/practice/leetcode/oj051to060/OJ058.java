package practice.leetcode.oj051to060;

/**
 * Created by xiaoyue26 on 17/11/28.
 */
public class OJ058 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int count = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        if (i < 0) {
            return 0;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        OJ058 obj = new OJ058();
        System.out.println(obj.lengthOfLastWord("b   a    "));
    }
}
