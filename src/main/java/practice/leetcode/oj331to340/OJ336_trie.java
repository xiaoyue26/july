package practice.leetcode.oj331to340;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OJ336_trie {
    private static class TrieNode {
        TrieNode[] next;
        int index;// 如果是末尾字母, 在原数组中的下标
        List<Integer> list;

        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) addWord(root, words[i], i);
        for (int i = 0; i < words.length; i++) search(words, i, root, res);

        return res;
    }

    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';
            if (root.next[j] == null) root.next[j] = new TrieNode();
            if (isPalindrome(word, 0, i)) root.list.add(index);
            root = root.next[j];
        }

        root.list.add(index);
        root.index = index;
    }

    private void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
        // case4的逆: s1[cut+1:] isPalindrome
        // s1[0:cur] = reverse(s2)
        // (s1,s2)
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i
                    && isPalindrome(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(i, root.index));
            }

            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }
        // words[i]走到了尽头(s1.length<s2.length)
        // case3的逆: s2[0:cut] isPalindrome
        // s1 = reverse(s2[cur+1:])
        // (s1,s2)
        for (int j : root.list) {
            if (i == j) continue;
            res.add(Arrays.asList(i, j));
        }
    }

    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        OJ336_trie obj = new OJ336_trie();
        System.out.println(obj.palindromePairs(new String[]{
                        "bat", "tab", "cat"
                }
        ));//[[0, 1], [1, 0]]
        // ["battab", "tabbat"]
        System.out.println(obj.palindromePairs(new String[]{
                        "abcd", "dcba", "lls", "s", "sssll"
                }
        ));//[[0, 1], [1, 0], [3, 2], [2, 4]]
        // ["dcbaabcd", "abcddcba", "slls", "llssssll"]

    }
}