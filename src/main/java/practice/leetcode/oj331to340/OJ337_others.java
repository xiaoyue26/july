package practice.leetcode.oj331to340;

import practice.leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class OJ337_others {
    public int rob(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }

    public static void main(String[] args) {
        OJ337_others obj = new OJ337_others();
        System.out.println(obj.rob(new TreeNode("3,2,3,#,3,#,1")));
        // 7 // 3+3+1
        System.out.println(obj.rob(new TreeNode("3,4,5,1,3,#,1")));
        // 9 // 4+5
    }
}