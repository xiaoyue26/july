package practice.leetcode.oj141to150;

import practice.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaoyue26 on 18/1/1.
 */
public class OJ145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, pre = null, tmp;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {// cur=null
                tmp = stack.peek();
                if (tmp.right != null && pre != tmp.right) {
                    cur = tmp.right;
                } else {
                    res.add(tmp.val);
                    stack.pop();// cur维持null
                    pre = tmp;
                }
            }
        }
        return res;
    }




    public static void main(String[] args) {
        OJ145 obj = new OJ145();
        TreeNode root = new TreeNode("1,#,2,#,#,3");// 3,2,1
        System.out.println(obj.postorderTraversal(root));
    }
}
