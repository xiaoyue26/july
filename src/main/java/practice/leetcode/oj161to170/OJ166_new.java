package practice.leetcode.oj161to170;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 18/1/7.
 */
public class OJ166_new {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "NAN";
        }
        StringBuilder res = new StringBuilder();
        // get op
        if ((numerator ^ denominator) < 0) {
            res.append('-');
        }
        long num = Math.abs((long) numerator);
        long div = Math.abs((long) denominator);
        // get integer
        long a = num / div;
        num = num - div * a;
        res.append(a);
        if (num == 0) {
            return res.toString();
        }
        // get tail 只有小数部分才会循环
        res.append('.');
        Map<Long, Integer> map = new HashMap<>();
        int index = res.length();
        while (num != 0) {
            if (map.containsKey(num)) {
                int cycleHead = map.get(num);
                res.insert(cycleHead,'(');
                res.append(')');
                return res.toString();
            } else {
                map.put(num, index);
            }
            num *= 10;
            a = num / div;
            num = num - a * div;
            res.append(a);
            index++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        OJ166_new obj = new OJ166_new();
        System.out.println(obj.fractionToDecimal(1, 2));//0.5
        System.out.println(obj.fractionToDecimal(2, 1));//2
        System.out.println(obj.fractionToDecimal(2, 3));//0.(6)
    }
}
