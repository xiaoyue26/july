package practice.leetcode.oj011to020;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/5.
 */
public class OJ017_dfs {
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
        List<String> res = new ArrayList<>();
        dfs(digits, "", res);
        return res;

    }

    private void dfs(String digits, String pre, List<String> res) {
        if (digits.length() == 0) {
            res.add(pre);
            return;
        }
        String chars = words[digits.charAt(0) - '0'];
        for (int i = 0; i < chars.length(); i++) {
            dfs(digits.substring(1), pre + chars.charAt(i), res);
        }


    }

    public static void main(String[] args) {
        OJ017_dfs obj = new OJ017_dfs();
        String digits = "23"; // ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
        System.out.println(obj.letterCombinations(digits));
    }
}
