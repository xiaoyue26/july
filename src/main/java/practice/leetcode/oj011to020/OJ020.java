package practice.leetcode.oj011to020;

/**
 * Created by xiaoyue26 on 17/11/6.
 */
public class OJ020 {
    public boolean isValid(String s) {
        char[] stack = new char[s.length() / 2 + 1];
        int top = -1;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    if (top == stack.length - 1) {
                        return false;
                    }
                    stack[++top] = c;
                    break;
                case '}':
                    if (top == -1 || stack[top] != '{') {
                        return false;
                    }
                    top--;
                    break;
                case ']':
                    if (top == -1 || stack[top] != '[') {
                        return false;
                    }
                    top--;
                    break;
                case ')':
                    if (top == -1 || stack[top] != '(') {
                        return false;
                    }
                    top--;
                    break;
                default:
                    break;
            }

        }
        return top == -1;
    }

    public static void main(String[] args) {
        OJ020 obj = new OJ020();
        System.out.println(obj.isValid("{}[]()"));
    }
}
