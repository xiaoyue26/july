package practice.leetcode.oj211to220;

import java.util.*;

/**
 * Created by xiaoyue26 on 18/1/21.
 * 可以改进的地方:
 * 1. charAt改成 [][], 先toCharArray;
 * 2. StringBuilder去掉,HashSet去掉,改成在TrieNode里存单词,用完置为null;
 * 3. visited去掉,改为在原board里存这个信息.
 */
public class OJ212 {
    public static class TrieNode {
        public boolean isWord = false;
        public TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root = new TrieNode();

    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        cur.isWord = true;
    }

    /**
     * @return 0: 有前缀
     * 1: 有单词
     * -1: 没前缀
     */
    public int searchPrefix(String word) {
        if (word == null || word.length() == 0) {
            return -1;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                return -1;
            }
            cur = cur.children[c];
        }
        if (cur.isWord) {
            return 1;
        } else {
            return 0;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || words == null) {
            return new ArrayList<>();
        }
        for (String word : words) {
            addWord(word);
        }
        List<String> res = new LinkedList<>();
        Set<String> tmpRes = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, sb, tmpRes, visited);
            }
        }
        res.addAll(tmpRes);
        return res;
    }

    private void dfs(int i, int j, char[][] board, StringBuilder sb, Set<String> res, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        sb.append(board[i][j]);
        visited[i][j] = true;
        int flag = searchPrefix(sb.toString());
        if (flag == -1) {
            sb.deleteCharAt(sb.length() - 1);
            visited[i][j] = false;
            return;
        }
        if (flag == 1) {
            res.add(sb.toString());
        }
        dfs(i + 1, j, board, sb, res, visited);
        dfs(i - 1, j, board, sb, res, visited);
        dfs(i, j + 1, board, sb, res, visited);
        dfs(i, j - 1, board, sb, res, visited);
        sb.deleteCharAt(sb.length() - 1);
        visited[i][j] = false;

    }

    public static void main(String[] args) {
        OJ212 obj = new OJ212();
        System.out.println(obj.findWords(new char[][]{
                        {'o', 'a', 'a', 'n'}
                        , {'e', 't', 'a', 'e'}
                        , {'i', 'h', 'k', 'r'}
                        , {'i', 'f', 'l', 'v'}
                }
                , new String[]{
                        "oath", "pea", "eat", "rain"
                }));
    }
}
