package practice.leetcode.oj091to100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 17/12/11.
 */
public class OJ091 {


    public int numDecodings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int dp[] = new int[s.length() + 1];
        dp[0] = 0;
        dp[1] = getDp(s.charAt(0));
        if(s.length()==1){
            return dp[1];
        }
        dp[2] = getDp(s.charAt(0), s.charAt(1))+getDp(s.charAt(1))*dp[1];
        for (int i = 3; i <= s.length(); i++) {
            int num1 = getDp(s.charAt(i - 1));
            int num2 = getDp(s.charAt(i - 2), s.charAt(i - 1));
            dp[i] = dp[i - 1] * num1 + dp[i - 2] * num2;
        }


        return dp[s.length()];
    }

    private int getDp(char c1, char c2) {
        int sum = getDp(c1) * getDp(c2);
        int tmp = (c1 - '0') * 10 + c2 - '0';
        if (tmp >= 10 && tmp <= 26) {
            sum += 1;
        }
        return sum;

    }

    private int getDp(char c) {
        if (c > '0' && c <= '9') {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        OJ091 obj = new OJ091();
        System.out.println(obj.numDecodings("111"));
    }
}
