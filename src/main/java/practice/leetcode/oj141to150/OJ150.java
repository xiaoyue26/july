package practice.leetcode.oj141to150;

import java.util.Stack;

/**
 * Created by xiaoyue26 on 18/1/3.
 */
public class OJ150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer a,b;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b + a);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.isEmpty()?0:stack.pop();
    }

    public static void main(String[] args) {
        OJ150 obj = new OJ150();
        String[] tokens = new String[]{
                "2", "1", "+", "3", "*"//9
                //"4", "13", "5", "/", "+"//6
        };
        System.out.println(obj.evalRPN(tokens));
    }
}
