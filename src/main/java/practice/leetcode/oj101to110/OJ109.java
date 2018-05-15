package practice.leetcode.oj101to110;

import practice.leetcode.utils.ListNode;
import practice.leetcode.utils.TreeNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/12/17.
 */
public class OJ109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        ListNode pre = dumpHead, cur = head;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        ListNode mid = pre.next;
        TreeNode root = new TreeNode(mid.val);
        if (pre.next != head) {
            pre.next = null;
            root.left = sortedListToBST(head);
        }
        root.right=sortedListToBST(mid.next);
        return root;
    }

    public static void main(String[] args) {
        OJ109 obj = new OJ109();
        ListNode head = new ListNode(Arrays.asList(
                -10, -3, 0, 5, 9
        ));
        System.out.println(obj.sortedListToBST(head));
    }
}
