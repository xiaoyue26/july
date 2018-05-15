package practice.leetcode.oj101to110;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 17/12/17.
 */
public class OJ106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[r2]);
        int i;
        for (i = l1; i <= r1; i++) {
            if (inorder[i] == postorder[r2]) {
                break;
            }
        }
        root.left = buildTree(inorder, l1, i - 1, postorder, l2, l2 + (i - l1) - 1);
        root.right = buildTree(inorder, i + 1, r1, postorder, l2 + (i - l1), r2 - 1);
        return root;
    }

    public static void main(String[] args) {
        OJ106 obj = new OJ106();
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        System.out.println(obj.buildTree(inorder, postorder));
    }
}
