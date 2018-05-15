package practice.leetcode.oj041to050;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/21.
 */
public class OJ043 {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() < 1 || num2 == null || num2.length() < 1) {
            return "0";
        }
        int max = num1.length() + num2.length()+1;
        char[] res = new char[max];
        Arrays.fill(res, '0');
        char ci, cj;
        int tmp, index;

        for (int i = num1.length() - 1; i >= 0; --i) {
            ci = num1.charAt(i);
            for (int j = num2.length() - 1; j >= 0; --j) {
                cj = num2.charAt(j);
                tmp = (ci - '0') * (cj - '0');
                index = i + j + 2;
                res[index] = (char) (tmp + res[index]);

                while (res[index] > '9') {
                    res[index - 1] = (char) ((res[index] - '0') / 10 + res[index - 1]);
                    res[index] = (char) ((res[index] - '0') % 10 + '0');
                    index--;
                }


            }
        }
        for (index = 0; index < max; index++) {
            if (res[index] != '0') {
                break;
            }
        }
        if (index >= max) {
            return "0";
        }
        return new String(res, index, max - index);
    }

    public static void main(String[] args) {
        OJ043 obj = new OJ043();
        String num1 = "999";
        String num2 = "999";
        System.out.println(obj.multiply(num1, num2));
        System.out.println(Integer.valueOf(num1) * Integer.valueOf(num2));
    }
}
