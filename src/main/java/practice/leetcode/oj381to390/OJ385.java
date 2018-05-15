package practice.leetcode.oj381to390;

import practice.leetcode.utils.NestedInteger;
import practice.leetcode.utils.NestedIntegerNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author xiaoyue26
 */
public class OJ385 {

    public NestedInteger deserialize(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.charAt(0) != '[') {
            return new NestedIntegerNode(Integer.valueOf(s));
        }

        Deque<NestedInteger> stack = new LinkedList<>();
        NestedInteger curr = null;
        int l = 0; // l shall point to the start of a number substring;
        // r shall point to the end+1 of a number substring
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (ch == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedIntegerNode();
                l = r + 1;
            } else if (ch == ']') {
                String num = s.substring(l, r);
                if (!num.isEmpty())
                    curr.add(new NestedIntegerNode(Integer.valueOf(num)));
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                l = r + 1;
            } else if (ch == ',') {
                if (s.charAt(r - 1) != ']') {
                    String num = s.substring(l, r);
                    curr.add(new NestedIntegerNode(Integer.valueOf(num)));
                }
                l = r + 1;
            }
        }

        return curr;

    }


    public static void main(String[] args) {
        OJ385 obj = new OJ385();
        NestedInteger res = obj.deserialize("[123,[456,[789]]]");
        System.out.println(res.getInteger());
        System.out.println(res.getList());


    }
}
