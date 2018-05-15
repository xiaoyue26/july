package practice.leetcode.oj301to310;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiuzhoumu on 2018/2/20.
 * 正反扫一遍
 */
public class OJ301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; ++j)
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }

    public static void main(String[] args) {
        OJ301 obj = new OJ301();
        System.out.println(obj.removeInvalidParentheses("()())()"));// ["()()()", "(())()"]
        System.out.println(obj.removeInvalidParentheses("(a)())()"));// ["(a)()()", "(a())()"]
        System.out.println(obj.removeInvalidParentheses(")("));//[]
    }
}
