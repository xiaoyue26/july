package practice.leetcode.oj031to040;

import java.util.Stack;

/**
 * Created by xiaoyue26 on 17/11/16.
 */
public class OJ032 {

    public static class Node {
        int index;
        char val;

        public Node(int i, char v) {
            index = i;
            val = v;
        }
    }

    public int longestValidParentheses(String s) {// 理解起来很简单的解法 O(n)空间 O(n)时间
        if (s == null || s.length() == 0) {
            return 0;
        }
        int top = -1;
        Node[] stack = new Node[s.length()];
        boolean[] flags = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack[++top] = new Node(i, '(');
                    break;
                case ')':
                    if (top >= 0 && stack[top].val == '(') {
                        flags[stack[top].index] = true;
                        flags[i] = true;
                        top--;
                    } else {
                        stack[++top] = new Node(i, ')');
                    }
                    break;
                default:
                    break;
            }
        }
        // countAndClear
        int max = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (flags[i]) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        max = Math.max(count, max);
        return max;
    }

    public int longestValidParentheses_magic(String s) {// O(1)空间 O(n)时间  两遍扫描,正反各一次,保证不遗漏
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public int longestValidParentheses_stack(String s) {//O(n)空间 O(n)时间
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidParentheses_dp(String s) {//O(n)空间 O(n)时间
        if (s == null || s.length() < 2) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];// max len end with i-th char
        dp[0] = 0;
        if (s.startsWith("()")) {
            dp[1] = 2;
        }
        max = Math.max(max, dp[1]);

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                //update dp, max
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else { // '))'
                    int left = i - dp[i - 1] - 1;
                    if (left >= 0 && s.charAt(left) == '(') {
                        if (left - 1 >= 0) {
                            dp[i] = dp[i - 1] + dp[left - 1] + 2;
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                }
                max = Math.max(max, dp[i]);

            } else {
                // nothing
            }
        }
        return max;
    }


    public static void main(String[] args) {
        OJ032 obj = new OJ032();
        String s1 = "()";//2
        String s2 = "()()";//4
        String s3 = "()(()";//2
        String s4 = "(())";// 4
        String s5 = "())";// 2
        System.out.println(obj.longestValidParentheses_dp(s1));
        System.out.println(obj.longestValidParentheses_dp(s2));
        System.out.println(obj.longestValidParentheses_dp(s3));
        System.out.println(obj.longestValidParentheses_dp(s4));
        System.out.println(obj.longestValidParentheses_dp(s5));


    }
}
