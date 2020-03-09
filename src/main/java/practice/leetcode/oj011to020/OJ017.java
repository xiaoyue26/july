package practice.leetcode.oj011to020;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/11/5.
 */
public class OJ017 {
    private final static String[] words = {
            " " // 0
            , "" // 1
            , "abc"
            , "def"
            , "ghi"
            , "jkl"
            , "mno"
            , "pqrs"
            , "tuv"
            , "wxyz"//9
    };


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return new ArrayList<>();
        }
        List<String> preDp = new ArrayList<>();
        List<String> dp = new ArrayList<>(), tmp;
        char c;
        String w;
        for (int i = 0; i < digits.length(); i++) {
            c = digits.charAt(i);
            w = words[c - '0'];
            for (int j = 0; j < w.length(); j++) {
                c = w.charAt(j);
                if (i != 0) {
                    for (int k = 0; k < preDp.size(); k++) {
                        dp.add(preDp.get(k) + c);
                    }
                } else {// i ==0:
                    dp.add(c + "");
                }
            }
            preDp.clear();
            tmp = preDp;
            preDp = dp;
            dp = tmp;
        }
        return preDp;
    }

    public static void main(String[] args) {
        OJ017 obj = new OJ017();
        String digits = "23"; // ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
        System.out.println(obj.letterCombinations(digits));
    }
}
