package practice.leetcode.oj101to110;

import practice.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/16.
 */
public class OJ103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean goRight = true;
        List<Integer> row = new ArrayList<>();
        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            if (goRight) {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode cur = deque.pollLast();
                    if (cur != null) {
                        row.add(cur.val);
                        deque.offerFirst(cur.left);
                        deque.offerFirst(cur.right);
                    }
                }
            } else {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode cur = deque.pollFirst();
                    if (cur != null) {
                        row.add(cur.val);
                        deque.offerLast(cur.right);
                        deque.offerLast(cur.left);
                    }
                }
            }
            goRight = !goRight;
            if (row.size() > 0) {
                res.add(row);
                row = new ArrayList<>();
            }
        }


        return res;
    }

    public static void main(String[] args) {
        OJ103 obj = new OJ103();
        TreeNode root = new TreeNode("3,9,20,11,12,15,7");
        System.out.println(obj.zigzagLevelOrder(root));
        System.out.println(obj.zigzagLevelOrder(null));
    }
}
