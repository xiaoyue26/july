package practice.leetcode.oj311to320;

import java.util.Arrays;
import java.util.List;

public class OJ315 {
    class TreeNode {
        TreeNode left, right;
        int val;
        int leftTreeSize;

        public TreeNode(int val, int leftTreeSize) {
            this.val = val;
            this.leftTreeSize = leftTreeSize;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        if (nums == null || nums.length == 0) {
            return Arrays.asList(res);
        }
        TreeNode root = null;
        for (int i = nums.length - 1; i >= 0; --i) {
            root = insert(root, nums[i], res, i, 0);

        }
        return Arrays.asList(res);
    }

    private TreeNode insert(TreeNode node, int val, Integer[] res, int index, int smallSum) {
        if (node == null) {
            node = new TreeNode(val, 0);// 刚创建，肯定没有左子树
            res[index] = smallSum; // 来的路上已经收集清楚了目前为止有多少节点小于自己
            return node;
        }
        if (val < node.val) {
            node.leftTreeSize++;
            node.left = insert(node.left, val, res, index, smallSum);
        } else {
            smallSum += node.leftTreeSize
                    + (node.val < val ? 1 : 0);
            node.right = insert(node.right, val, res, index, smallSum);
        }
        return node;
    }

    public static void main(String[] args) {
        OJ315 obj = new OJ315();
        System.out.println(obj.countSmaller(new int[]{
                5, 2, 6, 1//2, 1, 1, 0
        }));
    }
}