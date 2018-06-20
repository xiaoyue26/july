package practice.leetcode.oj441to450;

import practice.leetcode.utils.TreeNode;

/**
 * @author xiaoyue26
 */
public class OJ449 {
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return null;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return null;
        }
    }

    public static void main(String[] args) {
        Codec obj = new Codec();
        TreeNode root=new TreeNode("");
        System.out.println(obj.deserialize(obj.serialize(root)));
    }
}
