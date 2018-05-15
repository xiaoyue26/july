package practice.leetcode.oj101to110;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 17/12/18.
 */
public class OJ110 {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        if (l == -1 || r == -1 || l - r > 1 || r - l > 1)
            return -1;
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        OJ110 obj = new OJ110();
        TreeNode root = new TreeNode("3,9,20");
        System.out.println(obj.isBalanced(root));
    }
}
