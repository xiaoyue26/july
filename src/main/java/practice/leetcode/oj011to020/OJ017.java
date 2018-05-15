package practice.leetcode.oj011to020;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/11/5.
 */
public class OJ017 {
    /*static Map<Character, List<Character>> map = new HashMap<>(10);

    static {
        map.put('0', Arrays.asList(' '));
        map.put('1', Arrays.asList(' '));
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

    }*/
    static String[] words = {
            " "
            , ""
            , "abc"
            , "def"
            , "ghi"
            , "jkl"
            , "mno"
            , "pqrs"
            , "tuv"
            , "wxyz"
    };


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return new ArrayList<>();
        }
        List<List<String>> dp = new ArrayList<>(digits.length());
        String l1 = words[digits.charAt(0) - '0'];
        List<String> res0 = new ArrayList<>(l1.length());
        for (int i = 0; i < l1.length(); ++i) {
            res0.add(new String(new char[]{l1.charAt(i)}));
        }
        dp.add(res0);
        for (int i = 1; i < digits.length(); i++) {
            List<String> res = new ArrayList<>();
            String chars = words[digits.charAt(i) - '0'];
            List<String> pre = dp.get(i - 1);
            for (String s : pre) {
                //for (Character c : chars) {
                for (int j = 0; j < chars.length(); j++) {
                    res.add(s + chars.charAt(j));
                }
            }
            dp.add(res);
        }

        return dp.get(digits.length() - 1);
    }

    public static void main(String[] args) {
        OJ017 obj = new OJ017();
        String digits = "23"; // ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
        System.out.println(obj.letterCombinations(digits));
    }
}
