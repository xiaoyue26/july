package practice.leetcode.oj311to320;

import java.util.Deque;
import java.util.LinkedList;

public class OJ316 {
    public String removeDuplicateLetters(String s) {
        int counts[] = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            counts[c - 'a']++;
        }
        boolean[] visited = new boolean[26];
        Deque<Character> stack = new LinkedList<>();
        for (char c : chars) {
            counts[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            // 赶出stack中，排序靠后而且可替代的
            while (!stack.isEmpty() && stack.peek() > c) {
                int i = stack.peek() - 'a';
                if (counts[i] > 0) {
                    stack.pop();
                    visited[i] = false;
                } else {
                    break;
                }
            }
            visited[c - 'a'] = true;
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());// 效率更高,但要改stack的名字，不能再叫stack了，改叫deque吧
            //sb.insert(0,stack.pop());// stringBuilder底层要挪数组，效率低
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        OJ316 obj = new OJ316();
        System.out.println(obj.removeDuplicateLetters("bcabc"));// abc
        System.out.println(obj.removeDuplicateLetters("cbacdcbc"));// acdb
    }
}