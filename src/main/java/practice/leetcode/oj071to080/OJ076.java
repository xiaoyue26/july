package practice.leetcode.oj071to080;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 17/12/4.
 */
public class OJ076 {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        //Arrays.fill(map,0);
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int lackCount = t.length();
        int begin = 0, end = 0;
        int minWordHead = 0, minWordLen = Integer.MAX_VALUE;

        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (map[endChar] > 0) {// t中需要这个char
                lackCount--;
            }
            map[endChar]--;//即使不需要,也把不需要的程度减1 (不需要的字母变成了负数)
            end++;

            while (lackCount == 0) {// 如果已经找到一个解: 记录和收缩
                if (end - begin < minWordLen) {//record res
                    minWordLen = end - begin;
                    minWordHead = begin;
                }
                // 收缩:
                if (map[s.charAt(begin)] == 0) {// 遇到的字母中,需要的字母才会是0. 不需要的字母、又遇到了,则会是负数。
                    lackCount++;// 缺失数+1
                }
                map[s.charAt(begin)]++; // 释放begin位置、更新状态
                begin++; // 收缩
            }
        }
        if (minWordLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minWordHead, minWordHead + minWordLen);
    }


    public static void main(String[] args) {
        OJ076 obj = new OJ076();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));//BANC
        int a=2;
    }
}
