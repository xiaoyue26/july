package practice.leetcode.oj251to260;

import practice.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyue26 on 18/2/7.
 */
public class OJ257 {
    public List<String> binaryTreePaths(TreeNode root) {// 尝试dfs
        List<String> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> tmp = new LinkedList<>();
        dfs(root, tmp, res);
        return res;
    }

    private void dfs(TreeNode root, List<TreeNode> tmp, List<String> res) {
        tmp.add(root);
        if (root.left == null && root.right == null) {
            res.add(joinTreeList(tmp, "->"));
        }
        if (root.left != null) {
            dfs(root.left, tmp, res);
        }
        if (root.right != null) {
            dfs(root.right, tmp, res);
        }
        tmp.remove(tmp.size() - 1);
    }

    private String joinTreeList(List<TreeNode> tmp, String delimer) {
        if (tmp.size() == 1) {
            return String.valueOf(tmp.get(0).val);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(tmp.get(0).val);
        for (int i = 1; i < tmp.size(); i++) {
            sb.append(delimer).append(tmp.get(i).val);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        OJ257 obj = new OJ257();
        TreeNode root = new TreeNode("1,2,3,#,5");
        System.out.println(obj.binaryTreePaths(root));
    }
}
