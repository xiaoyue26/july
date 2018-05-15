package practice.leetcode.oj101to110;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 17/12/16.
 * 也可以用层序
 */
public class OJ104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String[] args) {
        OJ104 obj = new OJ104();
        TreeNode root = new TreeNode("3,9,20,#,#,15,7");
        System.out.println(obj.maxDepth(root));
    }
}
