package practice.leetcode.oj091to100;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 17/12/14.
 */
public class OJ098 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min || max != null && root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        OJ098 obj = new OJ098();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        TreeNode root2= new TreeNode("10,5,15,6,20");
        System.out.println(obj.isValidBST(root2));
    }
}
