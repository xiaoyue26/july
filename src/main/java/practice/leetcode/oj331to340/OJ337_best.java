package practice.leetcode.oj331to340;

import practice.leetcode.utils.TreeNode;

public class OJ337_best {
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    public static void main(String[] args) {
        OJ337_best obj = new OJ337_best();
        System.out.println(obj.rob(new TreeNode("3,2,3,#,3,#,1")));
        // 7 // 3+3+1
        System.out.println(obj.rob(new TreeNode("3,4,5,1,3,#,1")));
        // 9 // 4+5
    }
}