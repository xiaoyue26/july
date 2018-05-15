package practice.leetcode.oj121to130;

import practice.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/24.
 */
public class OJ129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        res.add(0);
        dfs(root, res, 0);
        return res.get(0);
    }

    private void dfs(TreeNode root, List<Integer> res, int preSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            int r = res.get(0);
            r += preSum * 10 + root.val;
            res.set(0, r);
            return;
        }
        // else:
        dfs(root.left, res, preSum * 10 + root.val);
        dfs(root.right, res, preSum * 10 + root.val);
    }

    public static void main(String[] args) {
        OJ129 obj = new OJ129();
        TreeNode root = new TreeNode("1,2,3");
        System.out.println(obj.sumNumbers(root));
    }
}
