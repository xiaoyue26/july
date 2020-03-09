package practice.leetcode.oj021to030;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/11/11.
 */
public class OJ024_test {
    public ListNode swapPairs(ListNode head) {
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        ListNode pre = dumpHead, cur = head, tmp;
        while (cur != null && cur.next != null) {
            tmp = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            cur.next = tmp;
            cur = tmp;
            pre = pre.next.next;
        }
        return dumpHead.next;
    }

    public static void main(String[] args) {
        OJ024_test obj = new OJ024_test();
        ListNode head = new ListNode(Arrays.asList(1, 2, 3, 4));
        System.out.println(obj.swapPairs(head));
        head = new ListNode(Arrays.asList(1, 2, 3));
        System.out.println(obj.swapPairs(head));
    }
}
