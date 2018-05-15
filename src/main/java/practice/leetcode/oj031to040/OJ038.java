package practice.leetcode.oj031to040;

import java.util.Collections;

/**
 * Created by xiaoyue26 on 17/11/19.
 */
public class OJ038 {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String pre = "1";
        if (n == 1) {
            return pre;
        }
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char preChar = '.';
            int times = 0;
            for (int j = 0; j < pre.length(); j++) {
                if (pre.charAt(j) != preChar) {
                    // output preChar
                    if (times > 0) {
                        sb.append((char) (times + '0'));
                        sb.append(preChar);
                    }
                    preChar = pre.charAt(j);
                    times = 1;
                } else {
                    times += 1;
                }
            }
            // output preChar
            if (times > 0) {
                sb.append((char) (times + '0'));
                sb.append(preChar);
            }

            pre = sb.toString();
        }


        return pre;
    }

    public static void main(String[] args) {
        OJ038 obj = new OJ038();
        System.out.println(obj.countAndSay(1));
        System.out.println(obj.countAndSay(2));
        System.out.println(obj.countAndSay(3));
        System.out.println(obj.countAndSay(4));
        System.out.println(obj.countAndSay(5));
    }
}
