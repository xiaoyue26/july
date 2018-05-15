package practice.leetcode.oj161to170;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyue26 on 18/1/7.
 */
public class OJ166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

    private void divMod() {

    }


    public static void main(String[] args) {
        OJ166 obj = new OJ166();
        System.out.println(obj.fractionToDecimal(1, 2));//0.5
        System.out.println(obj.fractionToDecimal(2, 1));//2
        System.out.println(obj.fractionToDecimal(2, 3));//0.(6)
    }
}
