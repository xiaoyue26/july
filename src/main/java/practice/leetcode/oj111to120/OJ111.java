package practice.leetcode.oj111to120;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 17/12/18.
 */
public class OJ111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left==null){
            return minDepth(root.right)+1;
        }
        if(root.right==null){
            return minDepth(root.left)+1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }
    private int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);
        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        OJ111 obj = new OJ111();
        TreeNode root = new TreeNode("1,2,3,4,#,#,#");
        System.out.println(obj.minDepth(root));
    }
}
