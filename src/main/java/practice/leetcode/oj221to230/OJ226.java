package practice.leetcode.oj221to230;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 18/1/30.
 */
public class OJ226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
    }


    public static void main(String[] args) {
        OJ226 obj = new OJ226();
        TreeNode root = new TreeNode("4,2,7,1,3,6,9");
        System.out.println(obj.invertTree(root));
    }
}
