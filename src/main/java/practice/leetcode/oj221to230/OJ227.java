package practice.leetcode.oj221to230;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by xiaoyue26 on 18/1/30.
 */
public class OJ227 {

    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        final Deque<Integer> stack = new LinkedList<>();
        final Deque<Character> opStack = new LinkedList<>();
        stack.push(0);
        opStack.push('+');
        char[] data = s.trim().toCharArray();
        int num = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] >= '0' && data[i] <= '9') {
                // get number:
                num = data[i] - '0';
                while (i + 1 < data.length && data[i + 1] >= '0' && data[i + 1] <= '9') {
                    num = num * 10 + data[i + 1] - '0';
                    i++;
                }
                stack.push(num);
            } else if (data[i] == '+') {
                cal(stack, opStack, '+');
                opStack.push(data[i]);
            } else if (data[i] == '-') {
                cal(stack, opStack, '-');
                opStack.push(data[i]);
            } else if (data[i] == '*') {
                cal(stack, opStack, '*');
                opStack.push(data[i]);
            } else if (data[i] == '/') {
                cal(stack, opStack, '/');
                opStack.push(data[i]);
            } else if (data[i] == '(') {// 入栈

            } else if (data[i] == ')') {// 出栈

            }

        }
        cal(stack, opStack, '+');
        return stack.pop();
    }

    private static final Map<Character, Integer> opLevel = new HashMap<>();

    static {
        opLevel.put('+', 0);
        opLevel.put('-', 0);
        opLevel.put('*', 1);
        opLevel.put('/', 1);
    }

    private void cal(Deque<Integer> stack, Deque<Character> opStack, char opNext) {
        int nextLevel = opLevel.get(opNext);
        while (!opStack.isEmpty()) {
            char op = opStack.peek();
            int level = opLevel.get(op);
            if (level < nextLevel) {
                return;
            }
            opStack.pop();
            int num2 = stack.pop();
            int num1 = stack.pop();
            int res;
            switch (op) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num1 / num2;
                    break;
                default:
                    res = num1 + num2;
                    break;
            }
            stack.push(res);
        }
    }


    public static void main(String[] args) {
        OJ227 obj = new OJ227();
        System.out.println(obj.calculate("3+2*2")); // 7
        System.out.println(obj.calculate(" 3/2 ")); // 1
        System.out.println(obj.calculate(" 3+5 / 2 ")); // 5
        System.out.println(obj.calculate("100000000/1/2/3/4/5/6/7/8/9/10"));//27
        System.out.println(obj.calculate("1+2*5/3+6/4*2"));//6
    }
}

