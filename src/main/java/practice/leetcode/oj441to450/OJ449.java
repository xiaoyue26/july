package practice.leetcode.oj441to450;

import practice.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author xiaoyue26
 */
@SuppressWarnings("ALL")
public class OJ449 {
    public  static  class Codec {
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

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<TreeNode> res = levelOrder(root);
            return res.stream().map(node -> {
                if (node == null) {
                    return "#";
                } else {
                    return String.valueOf(node.val);
                }
            }).collect(Collectors.joining(",")).replaceAll("(,#)*$", "");

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String levelString) {
            String[] inS = levelString.split(",");
            if (inS[0].equals("#")) {
                return null;
            }
            TreeNode root = new TreeNode(0);
            root.val = Integer.valueOf(inS[0]);
            TreeNode preRoot = root;
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
                        if (cur != null) {
                            preRoot = cur;
                        } else {
                            return root;
                        }
                    } else {
                        preRoot = queue.poll();
                    }
                }
                if (cur != null && preRoot != cur) {
                    queue.offer(cur);
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Codec obj = new Codec();
        TreeNode root=new TreeNode("5,2,3");
        System.out.println(obj.deserialize(obj.serialize(root)));
    }
}
