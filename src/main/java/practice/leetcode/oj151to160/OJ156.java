package practice.leetcode.oj151to160;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 18/1/5.
 */
public class OJ156 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLen(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        OJ156 obj = new OJ156();
        ListNode l1 = new ListNode(Arrays.asList(1, 2));
        ListNode l2 = new ListNode(Arrays.asList(3, 4, 5));
        ListNode tail = new ListNode(Arrays.asList(6, 7, 8));
        l1.next.next = tail;
        l2.next.next.next = tail;
        System.out.println(obj.getIntersectionNode(l1, l2));
    }
}
