package practice.leetcode.oj331to340;


import java.util.Deque;
import java.util.LinkedList;

/*
 * stack可以进一步优化掉
 * */
public class OJ331 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Deque<String> stack = new LinkedList<>();
        if (nodes.length == 0 || nodes.length == 1 && nodes[0].equals("#")) {
            return true;
        }
        if (!nodes[0].equals("#")) {
            stack.push(nodes[0]);
        }
        for (int i = 1; i < nodes.length; i++) {
            if (stack.isEmpty()) {
                return false;
            }
            String left = nodes[i], right = null;
            ++i;
            if (i < nodes.length) {
                right = nodes[i];
                stack.pop();
                if (!right.equals("#")) {
                    stack.push(right);
                }
                if (!left.equals("#")) {
                    stack.push(left);
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        OJ331 obj = new OJ331();
        System.out.println(obj.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));// true
        System.out.println(obj.isValidSerialization("1,#"));// false
        System.out.println(obj.isValidSerialization("9,#,#,1"));// false
        System.out.println(obj.isValidSerialization("1"));// false
        System.out.println(obj.isValidSerialization("#,#,#"));// false
        String[] test = "".split(",");
        System.out.println("here");
    }
}