package practice.leetcode.oj021to030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/8.
 */
public class OJ022 {
    public List<String> generateParenthesis(int n) {
        if (n < 0) {
            return new ArrayList<>();
        }
        List<String> dp[] = new List[n + 1];
        dp[0] = Arrays.asList("");
        dp[1] = Arrays.asList("()");
        for (int i = 2; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> lefts = dp[j];
                List<String> rights = dp[i - j - 1];
                for (String l : lefts) {
                    for (String r : rights) {
                        dp[i].add(l + '(' + r + ')');
                    }
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        OJ022 obj = new OJ022();
        System.out.println(obj.generateParenthesis(3));
        // System.out.println(obj.generateParenthesis(4));
    }
}
