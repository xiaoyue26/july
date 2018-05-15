package practice.leetcode.oj131to140;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/12/29.
 * dfs 超时.
 */
public class OJ139_dfs {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, wordSet);

    }

    private boolean dfs(String s, Set<String> wordSet) {
        List<String> headList = new ArrayList<>();
        for (String word : wordSet) {
            if (s.startsWith(word)) {
                if (word.length() == s.length()) {
                    return true;
                }
                headList.add(word);
            }
        }
        // dfs
        for (String head : headList) {
            if (dfs(s.substring(head.length()), wordSet)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        OJ139_dfs obj = new OJ139_dfs();
        System.out.println(obj.wordBreak("bb", new ArrayList<>(Arrays.asList(
                "a", "b", "bbb", "bbbb"
        ))));
    }
}
