package practice.leetcode.oj021to030;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/8.
 */
public class OJ022_dfs {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, "", 0, 0, n);
        return list;
    }

    public void dfs(List<String> list, String str, int open, int close, int max) {

        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max)
            dfs(list, str + "(", open + 1, close, max);
        if (close < open)
            dfs(list, str + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        OJ022_dfs obj = new OJ022_dfs();
        System.out.println(obj.generateParenthesis(3));
        System.out.println(obj.generateParenthesis(4));
    }
}
