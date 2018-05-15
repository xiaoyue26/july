package practice.leetcode.oj221to230;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 18/1/28.
 * 完全二叉树计算节点数. 107ms
 */
public class OJ222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1;
        }
        if (root.right == null) {
            return 2;
        }
        int h1 = 0, h2 = 0, res = 1;
        TreeNode cur = root;
        while (cur != null) {
            cur = cur.left;
            h1++;
            res <<= 1;
        }
        cur = root;
        while (cur != null) {
            cur = cur.right;
            h2++;
        }
        if (h1 == h2) {
            return res - 1;
        }
        return countLeft(root.left, h1 - 1)
                + countRight(root.right, h2 - 1) + 1;
    }

    private int countRight(TreeNode root, int h2) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1;
        }
        if (root.right == null) {
            return 2;
        }
        int h1 = 0, res = 1;
        TreeNode cur = root;
        while (cur != null) {
            cur = cur.left;
            h1++;
            res <<= 1;
        }
        if (h1 == h2) {
            return res - 1;
        }
        return countLeft(root.left, h1 - 1)
                + countRight(root.right, h2 - 1) + 1;
    }

    private int countLeft(TreeNode root, int h1) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1;
        }
        if (root.right == null) {
            return 2;
        }
        int h2 = 0, res = 1;
        TreeNode cur = root;
        while (cur != null) {
            cur = cur.right;
            h2++;
            res <<= 1;
        }
        if (h1 == h2) {
            return res - 1;
        }
        return countLeft(root.left, h1 - 1)
                + countRight(root.right, h2 - 1) + 1;
    }

    public static void main(String[] args) {
        OJ222 obj = new OJ222();
        TreeNode root = new TreeNode("1,2,3,4,5,6,7,8,9,10");
        System.out.println(obj.countNodes(root));
    }
}
