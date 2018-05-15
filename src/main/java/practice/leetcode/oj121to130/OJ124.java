package practice.leetcode.oj121to130;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 17/12/22.
 */
public class OJ124 {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        oneSideMaxSum(root);
        return maxSum;
    }

    private int oneSideMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = oneSideMaxSum(root.left);//左子树的单路最大和
        int r = oneSideMaxSum(root.right);
        maxSum = Math.max(maxSum, root.val + Math.max(l, 0) + Math.max(r, 0));// 记录一下双路的最大和
        return root.val + Math.max(0, Math.max(l, r));// 返回单路最大和
    }

    public static void main(String[] args) {
        OJ124 obj = new OJ124();
        TreeNode root = new TreeNode("1,2,3");
        System.out.println(obj.maxPathSum(root));
    }
}
