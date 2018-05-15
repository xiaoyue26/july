package practice.leetcode.oj391to400;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiaoyue26
 */
public class OJ394 {
    public String decodeString(String s) {
        Deque<StringBuilder> stringStack = new LinkedList<>();
        Deque<Integer> factorStack = new LinkedList<>();
        StringBuilder buff = new StringBuilder();
        char[] cs = s.toCharArray();
        int factor = 0;
        for (char c : cs) {
            if (c >= '0' && c <= '9') {
                factor = factor * 10 + c - '0';
            } else if (c == '[') {
                factorStack.push(factor);
                stringStack.push(buff);
                buff = new StringBuilder();
                factor = 0;
            } else if (c == ']') {
                int f = factorStack.pop();
                StringBuilder cur = stringStack.pop();
                for (int i = 0; i < f; i++) {
                    cur.append(buff.toString());
                }
                buff = cur;
            } else {
                buff.append(c);
            }
        }
        return buff.toString();
    }

    public static void main(String[] args) {
        OJ394 obj = new OJ394();
        System.out.println(obj.decodeString("3[a]2[bc]")); // aaabcbc
        System.out.println(obj.decodeString("3[a2[c]]")); // accaccacc
        System.out.println(obj.decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
    }
}
