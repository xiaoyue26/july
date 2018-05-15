package practice.leetcode.oj211to220;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 18/1/22.
 * 只能从前面加
 */
public class OJ214 {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        //int[] table = getTable(temp);
        int table[] = new int[temp.length()];
        buildNext(temp, table);
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    private void buildNext(String str, int[] next) {
        next[0] = 0;
        int k = 0;
        for (int i = 1; i < str.length(); i++) {
            while (k > 0 && str.charAt(i) != str.charAt(k)) {
                k = next[k - 1];// 见注释K
            }
            if (str.charAt(i) == str.charAt(k)) {
                ++k;
            }
            next[i] = k;
        }
    }

    public int[] getTable(String s) {
        int[] table = new int[s.length()];
        //pointer that points to matched char in prefix part
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(index) == s.charAt(i)) {
                table[i] = table[i - 1] + 1;// 前后缀长度+1
                index++;
            } else {
                index = table[i - 1];
                while (index > 0 && s.charAt(index) != s.charAt(i)) {
                    index = table[index - 1];
                }
                if (s.charAt(index) == s.charAt(i)) {
                    index++;
                }
                table[i] = index;
            }
        }

        return table;
    }


    public static void main(String[] args) {
        OJ214 obj = new OJ214();
        System.out.println(obj.shortestPalindrome("aacecaaa"));//aaacecaaa
        System.out.println(obj.shortestPalindrome("abcd"));//dcbabcd
    }
}
