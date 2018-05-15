package practice.leetcode.oj231to240;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xiaoyue26 on 18/2/3.
 */
public class OJ232 {
    static class MyQueue {
        private Deque<Integer> stack1 = new LinkedList<>();
        private Deque<Integer> stack2 = new LinkedList<>();

        public MyQueue() {
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            peek();
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.size()==0 && stack2.size()==0;
        }
    }


    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(123);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
