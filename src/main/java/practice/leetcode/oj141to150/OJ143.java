package practice.leetcode.oj141to150;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/12/31.
 */
public class OJ143 {
    public void reorderList(ListNode head) {
        ListNode fast = head, slow;
        ListNode dump = new ListNode(-1);
        dump.next = head;
        slow = dump;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        // reverse slow.next to end
        ListNode cur = slow.next;
        slow.next = null;
        ListNode tmp;
        while (cur != null) {
            tmp = slow.next;
            slow.next = cur;
            cur = cur.next;
            slow.next.next = tmp;
        }

        // merge slow + head
        tmp=slow.next;
        slow.next=null;
        slow = tmp;
        while (slow != null) {
            tmp = head.next;
            head.next = slow;
            slow = slow.next;
            head.next.next = tmp;
            head = tmp;
        }
    }

    public static void main(String[] args) {
        OJ143 obj = new OJ143();
        ListNode head = new ListNode(Arrays.asList(
                1, 2, 3,4
        ));
        obj.reorderList(head);
        System.out.println(head);
    }
}
