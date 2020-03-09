package practice.leetcode.oj051to060;

/**
 * Created by xiaoyue26 on 17/11/28.
 */
public class OJ058_test {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int i = s.length() - 1;
        for (; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                break;
            }
        }
        int end = i;
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
        }
        int begin = i;
        return end - begin;
    }

    public static void main(String[] args) {
        OJ058_test obj = new OJ058_test();
        System.out.println(obj.lengthOfLastWord("b   a    "));
    }
}
