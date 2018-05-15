package practice.leetcode.oj111to120;

import practice.leetcode.utils.TreeLinkNode;

import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/20.
 * 如果空间O(n)的话,可以直接用oj116的方法;
 * 但要求O(1),所以只能morris了.
 */
public class OJ117 {
    public void connect(TreeLinkNode root) { // morris层序大法. 只能适用于这种结构的节点.
        if (root == null)
            return;
        TreeLinkNode dump = new TreeLinkNode(-1), pre, parent = root;
        while (parent != null) {
            pre = dump;
            pre.next = null;
            while (parent != null) {// 对一层进行串葫芦.
                if (parent.left != null) {
                    pre.next = parent.left;
                    pre = pre.next;
                }
                if (parent.right != null) {
                    pre.next = parent.right;
                    pre = pre.next;
                }
                parent = parent.next;
            }
            // go next level
            parent = dump.next;
        }

    }

    public static void main(String[] args) {
        OJ117 obj = new OJ117();
        TreeLinkNode root = new TreeLinkNode("1,2,3,4,5,#,7");
        obj.connect(root);
        List<TreeLinkNode> res = TreeLinkNode.levelOrder(root);
        for (TreeLinkNode r : res) {
            if (r != null) {
                if (r.next != null) {
                    System.out.println(r.next.val);
                } else {
                    System.out.println("#");
                }
            }

        }

    }
}
