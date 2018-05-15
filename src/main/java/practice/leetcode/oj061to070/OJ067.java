package practice.leetcode.oj061to070;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/1.
 */
public class OJ067 {
    public String addBinary(String a, String b) {
        if (a == null || a.length() < 1) {
            return b;
        }
        if (b == null || b.length() < 1) {
            return a;
        }
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        // then a.length>=b.length
        List<Character> res = new ArrayList<>(a.length());

        int carry = 0;

        for (int i = 0; i < b.length(); ++i) {
            int ia = a.charAt(a.length() - i - 1) - '0';
            int ib = b.charAt(b.length() - i - 1) - '0';
            res.add((char) ((ia + ib + carry) % 2 + '0'));
            carry = (ia + ib + carry) / 2;
        }
        // deal a left
        for (int i = b.length(); i < a.length(); i++) {
            int ia = a.charAt(a.length() - i - 1) - '0';
            res.add((char) ((ia + carry) % 2 + '0'));
            carry = (ia + carry) / 2;
        }
        if (carry > 0) {
            res.add('1');
        }
        StringBuilder sb = new StringBuilder(res.size());
        for (int i = res.size() - 1; i >= 0; --i) {
            sb.append(res.get(i));
        }
        //Collections.reverse(res);

        return sb.toString();
    }

    public static void main(String[] args) {
        OJ067 obj = new OJ067();
        System.out.println(obj.addBinary("11", "1"));//100
    }
}
