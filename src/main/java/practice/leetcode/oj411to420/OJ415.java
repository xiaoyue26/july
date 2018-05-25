package practice.leetcode.oj411to420;

/**
 * @author xiaoyue26
 */
public class OJ415 {
    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        char[] tmp;
        if (chars1.length > chars2.length) {
            tmp = chars1;
            chars1 = chars2;
            chars2 = tmp;
        }
        // now c1.length<=c2.length
        char c1, c2;
        int carry = 0;
        char[] res = new char[chars2.length + 1];
        int sum;
        for (int i = 0; i < chars1.length; i++) {
            c1 = chars1[chars1.length - 1 - i];
            c2 = chars2[chars2.length - 1 - i];
            sum = carry + (c1 - '0') + (c2 - '0');
            res[res.length - 1 - i] = (char) (sum % 10 + '0');
            carry = sum / 10;
        }
        for (int i = chars1.length; i < chars2.length; i++) {
            c2 = chars2[chars2.length - 1 - i];
            sum = carry + (c2 - '0');
            res[res.length - 1 - i] = (char) (sum % 10 + '0');
            carry = sum / 10;
        }
        if (carry > 0) {
            res[0] = (char) (carry % 10 + '0');
            return new String(res);
        }

        return new String(res, 1, res.length - 1);
    }

    public static void main(String[] args) {
        OJ415 obj = new OJ415();
        System.out.println(obj.addStrings("255", "255"));
    }
}
