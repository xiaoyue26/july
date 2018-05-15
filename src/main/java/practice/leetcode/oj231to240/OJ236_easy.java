package practice.leetcode.oj231to240;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 18/2/4.
 */
public class OJ236_easy {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }

    public static void main(String[] args) {
        OJ236_easy obj = new OJ236_easy();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(obj.lowestCommonAncestor(root, root.left, root.right));
    }
}
