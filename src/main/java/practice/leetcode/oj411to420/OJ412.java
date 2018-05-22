package practice.leetcode.oj411to420;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyue26
 */
public class OJ412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OJ412 obj = new OJ412();
        System.out.println(obj.fizzBuzz(15));
    }
}
