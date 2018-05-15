package practice.leetcode.oj321to330;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

public class OJ328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dump1 = new ListNode(-1), cur1 = dump1;
        ListNode dump2 = new ListNode(-1), cur2 = dump2;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            cur1.next = cur;
            cur2.next = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
            cur = cur.next.next;
        }
        head = dump1.next;
        if (cur != null) {
            cur1.next = cur;
            cur1 = cur1.next;
        }
        cur1.next = dump2.next;
        cur2.next = null;
        return head;
    }

    public static void main(String[] args) {
        OJ328 obj = new OJ328();
        ListNode head = new ListNode(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
        );
        System.out.println(obj.oddEvenList(head));
    }
}