package practice.leetcode.oj101to110;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 17/12/17.
 */
public class OJ105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0){
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if(l1>r1){
            return null;
        }
        TreeNode root = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return root;
        }
        int i;
        for (i = l2; i <= r2; i++) {
            if (inorder[i] == preorder[l1]) {
                break;
            }
        }
        root.left = buildTree(preorder, l1 + 1, l1 + (i - l2), inorder, l2, i - 1);
        root.right = buildTree(preorder, l1 + (i - l2) + 1, r1, inorder, i + 1, r2);


        return root;
    }

    public static void main(String[] args) {
        OJ105 obj = new OJ105();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        System.out.println(obj.buildTree(preorder, inorder));
    }
}
