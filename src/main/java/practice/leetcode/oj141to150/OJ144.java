package practice.leetcode.oj141to150;

import practice.leetcode.utils.TreeNode;

import java.util.*;

/**
 * Created by xiaoyue26 on 18/1/1.
 */
public class OJ144 {
    public List<Integer> preorderTraversal_stack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }

    /**
     * morris travel
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root, tmp;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                tmp = cur.left;
                while (tmp.right != null && tmp.right != cur) {
                    tmp = tmp.right;
                }
                if (tmp.right == null) {// first time
                    res.add(cur.val);
                    tmp.right = cur;
                    cur = cur.left;
                } else {// tmp.right=cur.right
                    tmp.right = null;
                    cur = cur.right;
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        OJ144 obj = new OJ144();
        TreeNode root = new TreeNode("1,#,2,#,#,3");
        System.out.println(obj.preorderTraversal(root));
    }
}
