package practice.leetcode.oj191to200;

import practice.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiaoyue26 on 18/1/14.
 */
public class OJ199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            while (!queue.isEmpty()) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    TreeNode cur = queue.poll();
                    if (i == len - 1) {
                        res.add(cur.val);
                    }
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }

            }

        }
        return res;
    }

    public static void main(String[] args) {
        OJ199 obj = new OJ199();
        System.out.println(obj.rightSideView(new TreeNode(
                "1,2,3,#,5,#,4" // 1,3,4
        )));
    }
}
