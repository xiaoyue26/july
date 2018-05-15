package practice.leetcode.oj231to240;

import practice.leetcode.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xiaoyue26 on 18/2/4.
 */
public class OJ236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> stack1 = null, stack2 = null;
        TreeNode cur = root, pre = null, tmp;
        while ((!stack.isEmpty() || cur != null) && (stack1 == null || stack2 == null)) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {// cur=null
                tmp = stack.peek();
                if (tmp.right != null && pre != tmp.right) {
                    cur = tmp.right;
                } else {
                    //res.add(tmp.val);
                    if (tmp == p) {
                        stack1 = new LinkedList<>(stack);
                    } else if (tmp == q) {
                        stack2 = new LinkedList<>(stack);
                    }
                    stack.pop();// cur维持null
                    pre = tmp;
                }
            }
        }
        if (stack1 == null || stack2 == null) {
            return null;
        }

        while (stack1.size() > stack2.size()) {
            stack1.pop();
        }
        while (stack1.size() < stack2.size()) {
            stack2.pop();
        }

        while (!stack1.isEmpty()) {
            cur=stack1.pop();
            if(cur==stack2.pop()){
                return cur;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        OJ236 obj = new OJ236();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(obj.lowestCommonAncestor(root, root.left, root.right));
    }
}
