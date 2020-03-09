package practice.leetcode.oj011to020;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/5.
 */
public class OJ017_dfs {
    private final static String[] words = {
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
        dfs(res, "", digits, 0);
        return res;
    }

    private void dfs(List<String> res, String pre, String digits, int begin) {
        if (begin == digits.length()) {
            // deal res
            res.add(pre);
            return;
        }
        char c = digits.charAt(begin);
        String w = words[c - '0'];
        for (int i = 0; i < w.length(); i++) {
            c = w.charAt(i);
            dfs(res, pre + c, digits, begin + 1);
        }
    }

    public static void main(String[] args) {
        OJ017_dfs obj = new OJ017_dfs();
        String digits = "23"; // ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
        System.out.println(obj.letterCombinations(digits));
    }
}
