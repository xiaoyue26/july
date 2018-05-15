package practice.leetcode.oj021to030;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/11/11.
 */
public class OJ024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dumpHead = new ListNode(-1);
        ListNode cur = dumpHead;
        dumpHead.next = head;
        while (head != null && head.next != null) {
            cur.next = head.next;
            head.next = cur.next.next;
            cur.next.next = head;
            cur = cur.next.next;
            head = head.next;
        }


        return dumpHead.next;
    }

    public static void main(String[] args) {
        OJ024 obj = new OJ024();
        ListNode head = new ListNode(Arrays.asList(1, 2, 3, 4));
        System.out.println(obj.swapPairs(head));
        head = new ListNode(Arrays.asList(1, 2, 3));
        System.out.println(obj.swapPairs(head));
    }
}
