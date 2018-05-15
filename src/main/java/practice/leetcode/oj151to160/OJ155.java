package practice.leetcode.oj151to160;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaoyue26 on 18/1/5.
 */

public class OJ155 {
    @NotThreadSafe
    public static class MinStack {

        /**
         * initialize your data structure here.
         */
        private final List<Integer> dp;//截止位置i的最小值
        private final Stack<Integer> stack;// 委托底层数据

        public MinStack() {
            dp = new LinkedList<>();
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            int curMin = x;
            if (dp.size() > 0) {
                curMin = Math.min(x, dp.get(dp.size() - 1));
            }
            dp.add(curMin);
        }

        public void pop() {
            stack.pop();
            dp.remove(dp.size()-1);
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return dp.get(dp.size()-1);
        }
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());// -3
        obj.pop();
        System.out.println(obj.top()); // 0
        System.out.println(obj.getMin()); // -2

    }
}
