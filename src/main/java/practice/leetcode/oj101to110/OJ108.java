package practice.leetcode.oj101to110;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 17/12/17.
 */
public class OJ108 {
    public TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        OJ108 obj = new OJ108();
        int nums[] = new int[]{-10, -3, 0, 5, 9};
        System.out.println(obj.sortedArrayToBST(nums));
    }
}
