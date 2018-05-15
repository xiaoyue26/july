package practice.leetcode.oj201to210;

/**
 * Created by xiaoyue26 on 18/1/18.
 */
public class OJ208 {
    public static class TrieNode {
        public boolean isWord = false;
        public TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (ws.children[cur - 'a'] == null) {
                ws.children[cur - 'a'] = new TrieNode();
            }
            ws = ws.children[cur - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (ws.children[cur - 'a'] == null) {
                return false;
            }
            ws = ws.children[cur - 'a'];
        }
        return ws.isWord;
    }
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);
            if (ws.children[cur - 'a'] == null) {
                return false;
            }
            ws = ws.children[cur - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        OJ208 obj = new OJ208();
        obj.insert("abc");
        System.out.println(obj.startsWith("k"));
        System.out.println(obj.startsWith("b"));
        System.out.println(obj.startsWith("a"));
        System.out.println(obj.startsWith("ab"));
        System.out.println(obj.search("a"));
        System.out.println(obj.search("abc"));

    }
}
