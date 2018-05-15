package practice.leetcode.oj141to150;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 18/1/2.
 */
public class OJ148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;
        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dump = new ListNode(-1);
        ListNode pre = dump;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                pre.next = left;
                left = left.next;
            } else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        if (left != null){
            pre.next = left;
        }
        if (right != null){
            pre.next = right;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        OJ148 obj = new OJ148();
        ListNode head = new ListNode(Arrays.asList(
                2, 4, 3, 5, 1
        ));
        System.out.println(obj.sortList(head));
    }
}
