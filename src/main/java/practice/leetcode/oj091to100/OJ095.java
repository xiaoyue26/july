package practice.leetcode.oj091to100;

import practice.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/13.
 * <p>
 * BST of 1..n
 */
public class OJ095 {
    public List<TreeNode> generateTrees(int n) {
        List<Integer> nums = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        return dfs(nums);
    }

    private List<TreeNode> dfs(List<Integer> nums) {

        List<TreeNode> res = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return res;
        }
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> left = nums.subList(0, i);
            List<TreeNode> leftRes = dfs(left);
            List<Integer> right = nums.subList(i + 1, nums.size());
            List<TreeNode> rightRes = dfs(right);
            if (leftRes.size() > 0 && rightRes.size() > 0) {
                for (TreeNode l : leftRes) {
                    for (TreeNode r : rightRes) {
                        TreeNode root = new TreeNode(nums.get(i));
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
                continue;
            }
            for (TreeNode l : leftRes) {
                TreeNode root = new TreeNode(nums.get(i));
                root.left=l;
                res.add(root);

            }
            for (TreeNode r : rightRes) {
                TreeNode root = new TreeNode(nums.get(i));
                root.right=r;
                res.add(root);
            }
            if (leftRes.size() == 0 && rightRes.size() == 0) {
                TreeNode root = new TreeNode(nums.get(i));
                res.add(root);
            }

        }

        return res;
    }

    public static void main(String[] args) {
        OJ095 obj = new OJ095();
        System.out.println(obj.generateTrees(3));
    }
}
