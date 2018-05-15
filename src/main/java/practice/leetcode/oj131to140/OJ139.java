package practice.leetcode.oj131to140;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/12/29.
 */
public class OJ139 {
    public static class TrieNode {
        boolean isWord;
        TrieNode[] c;

        private TrieNode(){
            isWord = false;
            c = new TrieNode[128];
        }
    }

    private void addWord(TrieNode t, String w) {
        for (int i = 0; i < w.length(); i++) {
            int j = (int)w.charAt(i);
            if (t.c[j] == null) t.c[j] = new TrieNode();
            t = t.c[j];
        }
        t.isWord = true;
    }

    private boolean wordBreak(String s, Set<String> wordDict) {
        TrieNode t = new TrieNode(), cur;
        for (String i : wordDict) addWord(t, i);
        char[] str = s.toCharArray();
        int len = str.length;
        boolean[] f = new boolean[len + 1];
        f[len] = true;

        for (int i = len - 1; i >= 0; i--) {
            //System.out.println(str[i]);
            cur = t;
            for (int j = i; cur != null && j < len ; j++) {
                cur = cur.c[(int)str[j]];
                if (cur != null && cur.isWord && f[j + 1]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[0];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return wordBreak(s, wordSet);

    }


    public static void main(String[] args) {
        OJ139 obj = new OJ139();
        System.out.println(obj.wordBreak("bb", new ArrayList<>(Arrays.asList(
                "a", "b", "bbb", "bbbb"
        ))));
    }
}
