package practice.leetcode.oj221to230;

import practice.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiaoyue26 on 18/1/30.
 * 与stack基本一样,只不过顺序上刻意沿着层序的顺序(其实没啥意义)
 */
public class OJ226_queue {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur, tmp;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

        return root;
    }


    public static void main(String[] args) {
        OJ226_queue obj = new OJ226_queue();
        TreeNode root = new TreeNode("4,2,7,1,3,6,9");
        System.out.println(obj.invertTree(root));
    }
}
