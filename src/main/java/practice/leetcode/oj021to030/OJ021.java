package practice.leetcode.oj021to030;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/11/7.
 */
public class OJ021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumpHead = new ListNode(-1), cur = dumpHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
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
