package practice.leetcode.oj221to230;

import practice.leetcode.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xiaoyue26 on 18/1/30.
 */
public class OJ226_stack {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        final Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode cur, tmp;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;

            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }

        }
        return root;
    }


    public static void main(String[] args) {
        OJ226_stack obj = new OJ226_stack();
        TreeNode root = new TreeNode("4,2,7,1,3,6,9");
        System.out.println(obj.invertTree(root));
    }
}
