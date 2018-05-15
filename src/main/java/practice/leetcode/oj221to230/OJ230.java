package practice.leetcode.oj221to230;

import practice.leetcode.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xiaoyue26 on 18/2/2.
 * 输入是构造好的二叉查找树
 * 插入删除频繁,找第k小频繁
 */
public class OJ230 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        int count = 1;
        while (!stack.isEmpty() || cur != null) {
            if (cur == null) {
                cur = stack.pop();
                if (count == k) {
                    return cur.val;
                }
                cur = cur.right;
                count++;
            } else {
                stack.push(cur);
                cur = cur.left;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        OJ230 obj = new OJ230();
        TreeNode root = new TreeNode("2,1,3");
        System.out.println(obj.kthSmallest(root, 3));
    }
}
