package practice.leetcode.oj011to020;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/11/6.
 */
public class OJ019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        if (n <= 0) {
            return head;
        }
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        ListNode left = dumpHead;
        ListNode right = head;
        //  make right n step far
        while (n > 1) {
            right = right.next;
            n--;
        }
        // left and right move
        while(right!=null&&right.next!=null){
            left=left.next;
            right=right.next;
        }

        // remove left.next
        //ListNode tmp=left.next.next;
        left.next=left.next.next;
        return dumpHead.next;
    }

    public static void main(String[] args) {
        OJ019 obj = new OJ019();
        ListNode head = new ListNode(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(head);
        System.out.println(obj.removeNthFromEnd(head, 5));
    }
}
