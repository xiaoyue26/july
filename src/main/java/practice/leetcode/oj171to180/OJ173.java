package practice.leetcode.oj171to180;

import practice.leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by xiaoyue26 on 18/1/10.
 * next() and hasNext() : O(1)
 * 时间O(1) 平均是O(1)就行
 * 空间O(h): 树的高度h
 * BST的中序遍历是顺序的.
 */
public class OJ173 {

    public static class BSTIterator {

        //private final Stack<TreeNode>stack=new Stack<>();
        private final Deque<TreeNode> stack = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            pushUtilLeft(root, stack);
        }

        private void pushUtilLeft(TreeNode root, Deque<TreeNode> stack) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }


        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode tmp=stack.pop();
            int res = tmp.val;
            if(tmp.right!=null){
                pushUtilLeft(tmp.right,stack);
            }
            return res;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode("2,1,3");
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
