package practice.leetcode.oj081to090;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/12/8.
 */
public class OJ086 {

    public ListNode partition(ListNode head, int x) {
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        ListNode lessTail = null;
        ListNode otherTail = null;
        boolean sw = false;
        while (head != null && (lessTail == null || otherTail == null)) {
            if (head.val < x) {
                lessTail = head;
            } else {
                otherTail = head;
                if (lessTail == null) {
                    sw = true;
                }
            }
            head = head.next;
        }
        if (sw && lessTail != null) {
            otherTail.next = null;
            lessTail.next = dumpHead.next;
            dumpHead.next = lessTail;
        }
        if (otherTail != null) {
            otherTail.next = null;
        }

        while (head != null) {
            if (head.val < x) {
                ListNode tmp = lessTail.next;
                lessTail.next = head;
                lessTail = head;
                head = head.next;
                lessTail.next = tmp;
            } else {
                otherTail.next = head;
                otherTail = head;
                head = head.next;
                otherTail.next = null;
            }

        }

        return dumpHead.next;
    }

    public static void main(String[] args) {
        OJ086 obj = new OJ086();
        ListNode head = new ListNode(Arrays.asList(
                //1, 4, 3, 2, 5, 2 // ans : 1,2,2,4,3,5
                1, 3, 2
        ));
        System.out.println(obj.partition(head, 3));
    }
}
