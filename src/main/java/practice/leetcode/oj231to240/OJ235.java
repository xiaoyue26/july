package practice.leetcode.oj231to240;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 18/2/4.
 */
public class OJ235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        // p.val<=q.val
        if (root.val < p.val) {
            // go right
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > q.val) {
            // go left
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }

    }

    public static void main(String[] args) {
        OJ235 obj = new OJ235();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(obj.lowestCommonAncestor(root, root.left, root.right));
    }
}
