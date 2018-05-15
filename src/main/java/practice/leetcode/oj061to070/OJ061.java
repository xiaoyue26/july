package practice.leetcode.oj061to070;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/11/30.
 */
public class OJ061 {
    // inplace:
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode left = head;
        ListNode right = head;
        int len = 0;
        while (right != null) {
            right = right.next;
            len++;
        }
        right = head;
        k = k % len;
        if(k==0){
            return head;
        }
        for (int i = 0; i < k && right != null; i++) {
            right = right.next;
        }
        if (right == null) {
            return head;
        }
        while (right.next != null) {// 原来的链表可不能有环
            left = left.next;
            right = right.next;
        }

        ListNode newHead = left.next;
        left.next = null;
        right.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        OJ061 obj = new OJ061();
        ListNode head = new ListNode(Arrays.asList(
                1, 2, 3, 4, 5
        ));
        for (int i = 0; i < 10; i++) {
            head = obj.rotateRight(head, i);
            System.out.println(head);
        }

    }
}
