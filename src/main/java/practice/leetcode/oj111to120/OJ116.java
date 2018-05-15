package practice.leetcode.oj111to120;

import practice.leetcode.utils.TreeLinkNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiaoyue26 on 17/12/19.
 */
public class OJ116 {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        TreeLinkNode cur = root, pre = null;
        queue.add(cur);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                cur = queue.poll();
                if (pre != null) {
                    pre.next = cur;
                }
                if (cur != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
                pre = cur;
            }
            pre=null;
        }
    }

    public static void main(String[] args) {
        OJ116 obj = new OJ116();
        TreeLinkNode root = new TreeLinkNode("1,2,3,4,5,6,7");
        System.out.println(root);
        obj.connect(root);
        List<TreeLinkNode> res = TreeLinkNode.levelOrder(root);
        for (TreeLinkNode r : res) {
            if (r != null) {
                if (r.next != null) {
                    System.out.println(r.next.val);
                } else {
                    System.out.println("#");
                }
            }

        }
    }
}
