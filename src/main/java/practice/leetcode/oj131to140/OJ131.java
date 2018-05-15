package practice.leetcode.oj131to140;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/25.
 */
public class OJ131 {
    public boolean isPalindrome(String str, int l, int r) {
        if (l == r) return true;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        dfs(s, res, tmp);
        return res;
    }

    private void dfs(String s, List<List<String>> res, List<String> tmp) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (s.length() == 1) {
            tmp.add(s);
            res.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                tmp.add(s.substring(0, i + 1));
                dfs(s.substring(i + 1), res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        OJ131 obj = new OJ131();
        System.out.println(obj.partition("aab"));
        System.out.println(obj.partition("bb"));
    }
}
