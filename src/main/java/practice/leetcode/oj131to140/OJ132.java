package practice.leetcode.oj131to140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaoyue26 on 17/12/25.
 * 尝试使用BFS失败,还是DP吧
 */
public class OJ132 {

    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];// dp[i]: [0,i) 需要划分多少次
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i - 1;// 默认划分为单字母.
        }
        for (int i = 0; i < s.length(); i++) {
            // 奇数 odd [i-j,i+j]
            for (int j = 0; i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j); j++) {
                dp[i + j + 1] = Math.min(
                        dp[i + j + 1]// 原来的
                        , 1 + dp[i - j]);//以i为分割点的新最小值  [i-j,i+j]为回文串
            }
            // 偶数 oven [i-j+1,i+j]
            for (int j = 1; i - j + 1 >= 0 && i + j < s.length() && s.charAt(i - j + 1) == s.charAt(i + j); j++) {
                dp[i + j + 1] = Math.min(
                        dp[i + j + 1]// 原来的
                        , 1 + dp[i - j + 1]);//以i为分割点的新最小值 [i-j+1,i+j]为回文串
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        OJ132 obj = new OJ132();
        System.out.println(obj.minCut("aab"));//1
        System.out.println(obj.minCut("bb"));//0
    }
}
