package practice.leetcode.oj091to100;

import org.apache.commons.lang.StringUtils;
import practice.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaoyue26 on 17/12/15.
 * Morris遍历的好处是,正好能获得前序的节点,而恢复二叉树也需要.
 * 原理的话,主要是线索二叉树,利用闲置的指针.
 */
public class OJ099 {
    public void recoverTree(TreeNode root) {//Morris Traversal
        TreeNode first = null, second = null, tmp, cur, pre = null;
        cur = root;
        while (cur != null) {
            if (cur.left == null) {
                if (pre != null) // check
                {
                    if (cur.val <= pre.val) // error
                    {
                        if (first == null) {
                            first = pre;
                            second = cur;
                        } else
                            second = cur;
                    }
                }
                pre = cur;// record
                cur = cur.right;
            } else {// cur.left!=null find the rightest of left subtree
                tmp = cur.left;
                while (tmp.right != null && tmp.right != cur) {
                    tmp = tmp.right;
                }
                if (tmp.right == null) { // first time here
                    tmp.right = cur;
                    cur = cur.left;
                } else {// tmp.right==cur,second time here
                    tmp.right = null;
                    if (pre != null) // check
                    {
                        if (cur.val <= pre.val) // error
                        {
                            if (first == null) {
                                first = pre;
                                second = cur;
                            } else
                                second = cur;
                        }
                    }
                    pre = cur;// record
                    cur = cur.right;
                }
            }
        }
        // swp:
        if (first != null) {
            int tmpval = first.val;
            first.val = second.val;
            second.val = tmpval;
        }

    }

    public void morrisInorderTravel(TreeNode root) {// morris还可以前根后根遍历
        TreeNode cur, tmp;
        List<Integer> res = new ArrayList<>();
        cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);// out
                cur = cur.right;
            } else {// cur.left!=null
                // find rightest of left subtree
                tmp = cur.left;
                while (tmp.right != null && tmp.right != cur) {
                    tmp = tmp.right;
                }
                if (tmp.right == null) {// first time here
                    tmp.right = cur;
                    cur = cur.left;
                } else {// second time here
                    tmp.right = null;
                    res.add(cur.val);// out
                    cur = cur.right;
                }
            }
        }
        System.out.println(StringUtils.join(res, ','));
    }

    public static void main(String[] args) {
        OJ099 obj = new OJ099();
        TreeNode root = new TreeNode("2,3,1");
        obj.recoverTree(root);
        System.out.println(root);
        root = new TreeNode("3,9,20,#,#,15,21");
        obj.morrisInorderTravel(root);
    }
}
