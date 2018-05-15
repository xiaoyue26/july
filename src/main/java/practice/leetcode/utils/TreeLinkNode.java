package practice.leetcode.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by xiaoyue26 on 17/12/19.
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;


    public TreeLinkNode(int x) {
        val = x;
    }

    public TreeLinkNode(String levelString) {
        String[] inS = levelString.split(",");
        this.val = Integer.valueOf(inS[0]);
        TreeLinkNode preRoot = this;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        int count = 0;
        for (int i = 1; i < inS.length; i++) {
            TreeLinkNode cur = null;
            if (!inS[i].equals("#")) {
                cur = new TreeLinkNode(Integer.valueOf(inS[i]));
            }
            if (count == 0) {
                count++;
                if (preRoot != null) {
                    preRoot.left = cur;
                }
            } else {
                if (preRoot != null) {
                    preRoot.right = cur;
                }
                count = 0;
                if (queue.isEmpty()) {
                    return;
                } else {
                    preRoot = queue.poll();
                }
            }
            queue.offer(cur);
        }
    }

    @Override
    public String toString() {
        List<TreeLinkNode> res = levelOrder(this);
        return res.stream().map(node -> {
            if (node == null) {
                return "#";
            } else {
                return String.valueOf(node.val);
            }
        }).collect(Collectors.joining(","));
        //return String.valueOf(this.val);
    }
    public static List<TreeLinkNode> levelOrder(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        List<TreeLinkNode> res = new ArrayList<>();
        TreeLinkNode cur = root;
        queue.add(cur);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            res.add(cur);
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return res;

    }

    public static void main(String[] args) {


    }

}
