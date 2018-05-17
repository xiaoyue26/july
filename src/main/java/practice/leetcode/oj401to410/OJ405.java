package practice.leetcode.oj401to410;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoyue26
 */
public class OJ405 {
    public String toHex(int num) {
        if (num == Integer.MIN_VALUE) {
            return "80000000";
        }
        if (num == 0) {
            return "0";
        }
        boolean flag = true;
        if (num < 0) {
            flag = false;
            num = Integer.MAX_VALUE + num + 1;
        }
        int a = num, b;
        Deque<Integer> reminds = new LinkedList<>();
        while (a > 0) {
            b = a % 16;
            a /= 16;
            reminds.push(b);
        }
        StringBuilder sb = new StringBuilder();
        if (!flag) {
            if (reminds.size() == 8) {
                Integer pre = reminds.pop();
                reminds.push(pre + 8);
            } else {
                for (int i = 0; i < 7 - reminds.size(); i++) {
                    reminds.push(0);
                }
                reminds.push(8);
            }
        }
        while (!reminds.isEmpty()) {
            Integer cur = reminds.pop();
            sb.append(int2char(cur));
        }
        return sb.toString();
    }

    private char int2char(int num) {
        if (num < 10) {
            return (char) ('0' + num);
        }
        return (char) ('a' + num - 10);
    }

    char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex_others(int num) {
        if (num == 0) return "0";
        String result = "";
        while (num != 0) {
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }

    public static void main(String[] args) {
        OJ405 obj = new OJ405();
        System.out.println(obj.toHex(26));
        System.out.println(obj.toHex(-1));
    }
}
