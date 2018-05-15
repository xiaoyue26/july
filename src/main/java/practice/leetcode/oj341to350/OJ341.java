package practice.leetcode.oj341to350;


import practice.leetcode.utils.NestedInteger;
import practice.leetcode.utils.NestedIntegerNode;

import java.util.*;

/*
 * 尽量懒加载.
 * 调用next前必须调用hasNext
 * */
public class OJ341 {
    public static class NestedIterator implements Iterator<Integer> {
        private final Deque<NestedInteger> stack;
        private int index;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new LinkedList<>();
            for (int i = nestedList.size() - 1; i >= 0; --i) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            // 注意这里的while
            while (!stack.isEmpty()) {
                NestedInteger curr = stack.peek();
                if (curr.isInteger()) {
                    return true; // 维持栈顶是数字即可
                }
                stack.pop();
                for (int i = curr.getList().size() - 1; i >= 0; i--) {
                    stack.push(curr.getList().get(i));
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        OJ341 obj = new OJ341();
        //System.out.println("there");
        List<NestedInteger> nestedList = new ArrayList<>();
        NestedIntegerNode nodeA = new NestedIntegerNode();
        NestedIntegerNode nodeB = new NestedIntegerNode();
        NestedIntegerNode nodeC = new NestedIntegerNode();

        NestedIntegerNode nodeA1 = new NestedIntegerNode(1);
        NestedIntegerNode nodeA2 = new NestedIntegerNode(1);
        NestedIntegerNode nodeB1 = new NestedIntegerNode(2);
        NestedIntegerNode nodeC1 = new NestedIntegerNode(1);
        NestedIntegerNode nodeC2 = new NestedIntegerNode(1);

        nodeA.setList(Arrays.asList(nodeA1, nodeA2));
        nodeB.setList(Arrays.asList(nodeB1));
        nodeC.setList(Arrays.asList(nodeC1, nodeC2));

        nestedList.add(nodeA);
        nestedList.add(nodeB);
        nestedList.add(nodeC);
        NestedIterator i = new NestedIterator(nestedList);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}