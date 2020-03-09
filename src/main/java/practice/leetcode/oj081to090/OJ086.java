package practice.leetcode.oj081to090;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/12/8.
 */
public class OJ086 {

    public ListNode partition(ListNode head, int x) {
        ListNode dumpLeft = new ListNode(-1);
        ListNode dumpRight = new ListNode(-1);
        ListNode leftTail = dumpLeft, rightTail = dumpRight;
        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = head;

            } else {
                rightTail.next = head;
                rightTail = head;
            }
            head = head.next;
            rightTail.next = null;
            leftTail.next = null;
        }

        if (rightTail != dumpRight) {
            leftTail.next = dumpRight.next;
        }
        return dumpLeft.next;
        //  return null;
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
