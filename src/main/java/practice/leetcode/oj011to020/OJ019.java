package practice.leetcode.oj011to020;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/11/6.
 */
public class OJ019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        ListNode dumpHead = new ListNode(-1);
        ListNode pre = dumpHead, cur = pre;
        dumpHead.next = head;
        for (int i = 0; i < n && cur != null; i++) {
            cur = cur.next;
        }
        if (cur == null) {
            return head;
        }
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        cur = pre.next.next;
        pre.next.next = null;
        pre.next = cur;
        return dumpHead.next;
    }

    public static void main(String[] args) {
        OJ019 obj = new OJ019();
        ListNode head = new ListNode(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(head);
        System.out.println(obj.removeNthFromEnd(head, 5));
    }
}
