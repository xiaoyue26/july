package practice.leetcode.oj111to120;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 17/12/18.
 */
public class OJ112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        if (root.left == null) {
            return hasPathSum(root.right, sum - root.val);
        }
        if (root.right == null) {
            return hasPathSum(root.left, sum - root.val);
        }

        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }


    public static void main(String[] args) {
        OJ112 obj = new OJ112();
        TreeNode root = new TreeNode("5,4,8,11,#,13,4,7,2,#,#,#,1");
        //TreeNode root = new TreeNode("1,2");
        int sum = 22;
        System.out.println(obj.hasPathSum(root, sum));
        System.out.println(obj.hasPathSum(null, 0));
    }
}
