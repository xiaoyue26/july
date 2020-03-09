package practice.leetcode.oj021to030;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/11/7.
 */
public class OJ021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumpHead = new ListNode(-1), pre = dumpHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (l1 == null) {
            pre.next = l2;
        } else {
            pre.next = l1;
        }
        return dumpHead.next;
    }

    public static void main(String[] args) {
        OJ021 obj = new OJ021();
        ListNode l1 = new ListNode(Arrays.asList(2, 4, 6));
        ListNode l2 = new ListNode(Arrays.asList(1, 3, 5));
        System.out.println(obj.mergeTwoLists(l1, l2));
    }
}
