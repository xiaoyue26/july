package practice.leetcode.oj101to110;

import practice.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiaoyue26 on 17/12/17.
 */
public class OJ107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> row = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                cur = queue.poll();
                if (cur != null) {
                    row.add(cur.val);
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            if (row.size() > 0) {
                res.offerFirst(row);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OJ107 obj = new OJ107();
        TreeNode root = new TreeNode("3,9,20,#,#,15,7");
        System.out.println(obj.levelOrderBottom(root));

    }
}
