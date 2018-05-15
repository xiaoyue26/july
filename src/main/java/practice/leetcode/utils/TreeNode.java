package practice.leetcode.utils;

import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by xiaoyue26 on 17/12/12.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(String levelString) {
        String[] inS = levelString.split(",");
        this.val = Integer.valueOf(inS[0]);
        TreeNode preRoot = this;
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        for (int i = 1; i < inS.length; i++) {
            TreeNode cur = null;
            if (!inS[i].equals("#")) {
                cur = new TreeNode(Integer.valueOf(inS[i]));
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
        List<TreeNode> res = TreeNode.levelOrder(this);
        return res.stream().map(node -> {
            if (node == null) {
                return "#";
            } else {
                return String.valueOf(node.val);
            }
        }).collect(Collectors.joining(","));
    }

    public static List<TreeNode> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> res = new ArrayList<>();
        TreeNode cur = root;
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
        TreeNode obj = new TreeNode(1);
        obj.right = new TreeNode(3);
        System.out.println(obj);

        TreeNode o2=new TreeNode("1,#,3,#,#");
        System.out.println(o2);
    }
}
