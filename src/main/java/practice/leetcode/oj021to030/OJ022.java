package practice.leetcode.oj021to030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/8.
 */
public class OJ022 {
    /*public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        if (n == 1) {
            res.add("()");
            return res;
        }
        List<String> preRes = generateParenthesis(n - 1);
        for (String r : preRes) {
            res.add("()"+r);
            res.add("("+r+")");
            if(!r.endsWith("()")){
                res.add(r+"()");
            }
        }
        return res;
    }*/

    public List<String> generateParenthesis(int n) {
        List<List<String>> dpList = new ArrayList<>();
        dpList.add(Arrays.asList(""));
        dpList.add(Collections.singletonList("()"));
        for (int i = 2; i < n + 1; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> left = dpList.get(j);
                for (String lString : left) {
                    List<String> right = dpList.get(i - j - 1);
                    for (String rString : right) {
                        cur.add(lString + '(' + rString + ')');
                    }
                }
            }
            dpList.add(cur);
        }
        return dpList.get(n);
    }
    public static void main(String[] args) {
        OJ022 obj = new OJ022();
        System.out.println(obj.generateParenthesis(3));
        System.out.println(obj.generateParenthesis(4));
    }
}
