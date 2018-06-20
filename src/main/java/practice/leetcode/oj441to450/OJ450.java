package practice.leetcode.oj441to450;

import practice.leetcode.utils.TreeNode;

/**
 * @author xiaoyue26
 */
public class OJ450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else { // key==root.val
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = null;
            root.right = null;
            // rotate right
            if (left != null) {
                if (right == null) {
                    return left;
                }
                TreeNode rightLeftMost = right;
                while (rightLeftMost.left != null) {
                    rightLeftMost = rightLeftMost.left;
                }
                rightLeftMost.left = left.right;
                left.right = right;
                return left;
            } else if (right != null) {// rotate left
                return right;
            } else {
                return null;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        OJ450 obj = new OJ450();
        TreeNode root = new TreeNode("5,3,6,2,4,#,7");
        System.out.println(obj.deleteNode(root, 3));
    }
}
