package practice.leetcode.oj171to180;

/**
 * Created by xiaoyue26 on 18/1/9.
 */
public class OJ171 {
    public int titleToNumber(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int res = 0, cur;
        for (int i = 0; i < s.length(); i++) {
            cur = (s.charAt(i) - 'A') + 1;
            res = res * 26 + cur;
        }

        return res;
    }

    public static void main(String[] args) {
        OJ171 obj = new OJ171();
        System.out.println(obj.titleToNumber("AB"));
    }
}
