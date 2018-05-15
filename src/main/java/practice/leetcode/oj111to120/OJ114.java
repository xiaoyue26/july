package practice.leetcode.oj111to120;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 17/12/19.
 * pre-order flatten
 */
public class OJ114 {
    public void flatten(TreeNode root) {// morris travel
        if (root == null) {
            return;
        }
        TreeNode pre = new TreeNode(-1);
        TreeNode cur = root;
        TreeNode tmp;
        pre.right = cur;
        while (cur != null) {
            //System.out.println(cur.val);
            if (cur.left == null) {
                cur = cur.right;
            } else {// cur.left!=null
                tmp = cur.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
                cur=cur.right;
            }
        }


    }

    public static void main(String[] args) {
        OJ114 obj = new OJ114();
        TreeNode root = new TreeNode("1,2,5,3,4,#,6");
        System.out.println(root);
        obj.flatten(root);
        System.out.println(root);
    }
}
