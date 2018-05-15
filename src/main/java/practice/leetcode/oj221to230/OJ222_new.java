package practice.leetcode.oj221to230;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 18/1/28.
 * 完全二叉树计算节点数. 58ms
 */
public class OJ222_new {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root.right, right = root.right;// 注意这里,left=root.right!
        int height = 0;
        while (right != null) {// 计算右子树是否是满二叉树
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null) {// && right == null // 右子树是满二叉树. (右子树的左右边长相等)
            return 1 + (1 << height) - 1 + countNodes(root.left);
        } else {// left!=null // 右子树不是满二叉树,因此左子树一定是满二叉树
            return 1 + (1 << (height + 1)) - 1 + countNodes(root.right);
        }
    }

    public static void main(String[] args) {
        OJ222_new obj = new OJ222_new();
        TreeNode root = new TreeNode("1,2,3,4,5,6");
        System.out.println(obj.countNodes(root));
    }
}
