package practice.leetcode.oj111to120;

import practice.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/18.
 */
public class OJ113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    public void dfs(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {// leaf node
            if (sum == root.val) {
                tmp.add(root.val);
                res.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size() - 1);
            }
            return;
        }

        tmp.add(root.val);
        dfs(root.right, sum - root.val, tmp, res);
        dfs(root.left, sum - root.val, tmp, res);
        tmp.remove(tmp.size() - 1);


    }

    public static void main(String[] args) {
        OJ113 obj = new OJ113();
        TreeNode root = new TreeNode("5,4,8,11,#,13,4,7,2,#,#,#,#,5,1");
        int sum = 22;
        System.out.println(obj.pathSum(root, sum));
    }
}
