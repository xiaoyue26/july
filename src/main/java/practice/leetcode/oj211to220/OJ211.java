package practice.leetcode.oj211to220;


/**
 * Created by xiaoyue26 on 18/1/20.
 */
public class OJ211 {
    public static class WordDictionary {
        public static class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public boolean isWord = false;
        }

        private TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }
            return search(word, 0, root);
        }

        private boolean search(String word, int begin, TrieNode cur) {
            if (cur == null) {
                return false;
            }
            if (begin >= word.length()) {
                return cur.isWord;
            }

            for (int i = begin; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == '.') {
                    for (int j = 0; j < 26; j++) {
                        if (search(word, i + 1, cur.children[j])) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    int index = c - 'a';
                    cur = cur.children[index];
                    if (cur == null) {
                        return false;
                    }
                }
            }
            return cur.isWord;
        }
    }


    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));//false
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}
