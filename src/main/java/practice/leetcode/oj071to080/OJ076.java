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

        int counter = t.length();
        int begin = 0, end = 0, head = 0;
        int res = Integer.MAX_VALUE;

        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (map[endChar] > 0) {// t中需要这个char
                counter--;
            }
            map[endChar]--;//即使不需要,也把不需要的程度减1 (不需要的字母变成了负数)
            end++;

            while (counter == 0) {
                if (end - begin < res) {//record res
                    res = end - begin;
                    head = begin;
                }
                // 收缩:
                if (map[s.charAt(begin)] == 0) {// 遇到的字母中,需要的字母才会是0.
                    counter++;
                }
                map[s.charAt(begin)]++;//回退
                begin++;// 收缩
            }


        }
        if (res == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(head, head + res);
    }


    public static void main(String[] args) {
        OJ076 obj = new OJ076();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));//BANC
        int a=2;
    }
}
