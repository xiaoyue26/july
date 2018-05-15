package practice.leetcode.oj141to150;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/12/30.
 */
public class OJ141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        OJ141 obj = new OJ141();
        ListNode head = new ListNode(Arrays.asList(1, 2, 3));
        System.out.println(obj.hasCycle(head));
    }
}
