package practice.leetcode.oj291to300;

import practice.leetcode.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jiuzhoumu on 2018/2/19.
 */
public class OJ297 {
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<String> res = new LinkedList<>();
            TreeNode cur;
            while (!queue.isEmpty()) {
                cur = queue.poll();
                if (cur != null) {
                    res.add(String.valueOf(cur.val));
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else {
                    res.add("#");
                }
            }
            return String.join(",", res);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nums = data.split(",");
            if (nums.length == 0) {
                return null;
            }
            if (nums.length == 1 || nums[0].equals("#")) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode pre, head = new TreeNode(Integer.valueOf(nums[0]));
            queue.offer(head);
            int i = 1;
            while (i < nums.length) {
                pre = queue.poll();
                pre.left = string2node(nums[i]);
                i++;
                if (pre.left != null) {
                    queue.offer(pre.left);
                }
                if (i < nums.length) {
                    pre.right = string2node(nums[i]);
                    i++;
                    if (pre.right != null) {
                        queue.offer(pre.right);
                    }
                }
            }

            return head;
        }

        private TreeNode string2node(String data) {
            if (data.equals("#")) {
                return null;
            } else {
                return new TreeNode(Integer.valueOf(data));
            }
        }
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode("1,2,3,4,5,6,7");
        System.out.println(codec.deserialize(codec.serialize(root)));
        System.out.println(codec.deserialize(codec.serialize(null)));
    }
}
