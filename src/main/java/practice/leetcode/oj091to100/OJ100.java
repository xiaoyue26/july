package practice.leetcode.oj091to100;

import practice.leetcode.utils.TreeNode;

/**
 * Created by xiaoyue26 on 17/12/15.
 */
public class OJ100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null){
            return q==null;
        }
        if(q==null){
            return p==null;
        }
        if(p.val!=q.val){
            return false;
        }
        if(!isSameTree(p.left,q.left)){
            return false;
        }
        if(!isSameTree(p.right,q.right)){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        OJ100 obj = new OJ100();
        TreeNode p = new TreeNode("1,2,3");
        TreeNode q = new TreeNode("1,3,2");
        System.out.println(obj.isSameTree(p, q));
    }
}
