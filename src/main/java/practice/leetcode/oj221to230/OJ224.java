package practice.leetcode.oj221to230;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by xiaoyue26 on 18/1/29.
 */
public class OJ224 {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                // get num
                int num = s.charAt(i) - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                stack.push(stack.pop() + sign * num);
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') { // 类似一次函数入栈
                stack.push(sign); // 暂存之前的操作符
                stack.push(0);// 新建一个结果目, 和之前的结果隔离
                sign = 1; // 这次结果的操作符
            } else if (s.charAt(i) == ')') { // 类似一次函数出栈
                int curRes = stack.pop();
                int preSign = stack.pop();
                int preRes = stack.pop();
                stack.push(curRes * preSign + preRes);
            }
            // else ignore
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        OJ224 obj = new OJ224();
        System.out.println(obj.calculate("1 + 1"));
        System.out.println(obj.calculate(" 2-1 + 2 "));
        System.out.println(obj.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
