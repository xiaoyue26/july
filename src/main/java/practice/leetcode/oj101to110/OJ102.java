package practice.leetcode.oj101to110;

import practice.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiaoyue26 on 17/12/16.
 * 层序,不用补null或#
 */
public class OJ102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        Queue<TreeNode> curQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        curQueue.offer(root);
        while (!curQueue.isEmpty()) {
            while (!curQueue.isEmpty()) {
                TreeNode cur = curQueue.poll();
                if (cur != null) {
                    row.add(cur.val);
                    nextQueue.offer(cur.left);
                    nextQueue.offer(cur.right);
                }
            }
            if (row.size() > 0) {
                res.add(row);
                row = new ArrayList<>();
                Queue<TreeNode> tmp = curQueue;
                curQueue = nextQueue;
                nextQueue = tmp;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        OJ102 obj = new OJ102();
        TreeNode root = new TreeNode("3,9,20,#,#,15,7");
        System.out.println(obj.levelOrder(root));
        System.out.println(obj.levelOrder(null));
    }
}
