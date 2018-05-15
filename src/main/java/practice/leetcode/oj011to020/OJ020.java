package practice.leetcode.oj011to020;

/**
 * Created by xiaoyue26 on 17/11/6.
 */
public class OJ020 {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '{':
                case '[':
                case '(':
                    stack[++top] = s.charAt(i);
                    break;
                case '}':
                    if (top < 0 || stack[top] != '{') {
                        return false;
                    }
                    top--;
                    break;
                case ']':
                    if (top < 0 || stack[top] != '[') {
                        return false;
                    }
                    top--;
                    break;
                case ')':
                    if (top < 0 || stack[top] != '(') {
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
