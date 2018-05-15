package practice.leetcode.oj101to110;

import practice.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by xiaoyue26 on 17/12/16.
 * 对称
 */
public class OJ101 {
    public boolean isSymmetric(TreeNode root) {// 循环,层序试试
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            if (levelSize % 2 == 1) {
                return false;
            }
            Stack<TreeNode> stack = new Stack<>();
            for (int i = 0; i < levelSize / 2; i++) {
                TreeNode cur = queue.poll();
                stack.push(cur);
                if (cur != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            for (int i = 0; i < levelSize / 2; i++) {
                TreeNode right = queue.poll();
                TreeNode left = stack.pop();
                if (!isSameNode(left, right)) {
                    return false;
                }
                if (right != null) {
                    queue.offer(right.left);
                    queue.offer(right.right);
                }
            }
        }
        return true;
    }

    private boolean isSameNode(TreeNode left, TreeNode right) {
        if (right == null) {
            return left==null;
        }
        if (left == null) {
            return  right==null;
        }
        return left.val==right.val;
    }

    public boolean isSymmetric_iter(TreeNode root) {// 递归
        if (root == null) {
            return true;
        }
        return reverseTree(root.left, root.right);
    }

    private boolean reverseTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return r2 == null;
        }
        if (r2 == null) {
            return r1 == null;
        }

        if (r1.val != r2.val) {
            return false;
        }

        if (reverseTree(r1.left, r2.right) && reverseTree(r1.right, r2.left)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        OJ101 obj = new OJ101();
        TreeNode root = new TreeNode("1,2,2,3,4,4,3");//true
        System.out.println(obj.isSymmetric(root));
        root = new TreeNode("1,2,2,#,3,#,3");//false
        System.out.println(obj.isSymmetric(root));
    }
}
