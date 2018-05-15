package practice.leetcode.oj161to170;

/**
 * Created by xiaoyue26 on 18/1/8.
 * 正数转字母.     26转Z, 27转AA
 */
public class OJ168 {// 类似27进制

    public String convertToTitle(int n) {
        if (n < 1) {
            return "";
        }
        int cur;
        n -= 1;
        StringBuilder res = new StringBuilder();
        while (n >= 0) {
            cur = n % 26;
            res.append((char) (cur + 'A'));
            n = n / 26 - 1;
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        OJ168 obj = new OJ168();
        System.out.println(obj.convertToTitle(1));
        System.out.println(obj.convertToTitle(26));
        System.out.println(obj.convertToTitle(27));
        System.out.println(obj.convertToTitle(28));
    }
}
