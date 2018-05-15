package practice.leetcode.oj331to340;

import practice.leetcode.utils.TreeNode;

import java.util.*;

/*
 * dfs+暴力cache
 * XD
 * */
public class OJ337 {
    public int rob(TreeNode root) {
        return Math.max(rob(root, false), rob(root, true));
    }

    private int rob(TreeNode root, boolean skipRoot) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (skipRoot) {
            int left = Math.max(queryValue(root.left, false), queryValue(root.left, true));
            int right = Math.max(queryValue(root.right, false), queryValue(root.right, true));
            res += left + right;
        } else {
            int left2 = queryValue(root.left, true);
            int right2 = queryValue(root.right, true);
            res = left2 + right2 + root.val;
        }
        return res;
    }

    private Map<TreeNode, List<Integer>> map = new HashMap<>();

    private int queryValue(TreeNode node, boolean skipRoot) {
        List<Integer> res = map.getOrDefault(node
                , new ArrayList<>(Arrays.asList(-1, -1)));
        int index = skipRoot ? 0 : 1;
        int value = res.get(index);
        if (value == -1) {
            value = rob(node, skipRoot);
        }
        res.set(index, value);
        map.put(node, res);
        return value;
    }

    public static void main(String[] args) {
        OJ337 obj = new OJ337();
        System.out.println(obj.rob(new TreeNode("3,2,3,#,3,#,1")));
        // 7 // 3+3+1
        System.out.println(obj.rob(new TreeNode("3,4,5,1,3,#,1")));
        // 9 // 4+5
    }
}