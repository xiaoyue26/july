package practice.leetcode.oj221to230;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiaoyue26 on 18/1/29.
 * 用队列实现栈.
 * 队列上只能使用offer和poll操作.
 */
public class OJ225 {
    static class MyStack {
        private Queue<Integer> queue1 = new LinkedList<>();
        private Queue<Integer> queue2 = new LinkedList<>();

        public MyStack() {
        }

        public void push(int x) {
            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            Queue<Integer> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        System.out.println(obj.pop());
        //System.out.println(obj.top());
        System.out.println(obj.empty());
    }
}
