package practice.leetcode.oj091to100;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/12/11.
 */
public class OJ092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        // begin reverse
        ListNode cur = pre.next;
        ListNode preTail = cur;
        pre.next = null;
        for (int i = m; i <= n; i++) {
            ListNode tmp = pre.next;
            pre.next = cur;
            cur = cur.next;
            pre.next.next = tmp;
        }
        preTail.next=cur;
        return dump.next;
    }

    public static void main(String[] args) {
        OJ092 obj = new OJ092();
        ListNode head = new ListNode(Arrays.asList(
                1, 2, 3, 4, 5
        ));
        head=obj.reverseBetween(head, 2, 4);
        System.out.println(head);
        head=obj.reverseBetween(head, 1, 5);
        System.out.println(head);
        head=obj.reverseBetween(head, 1, 1);
        System.out.println(head);
        head=obj.reverseBetween(head, 2, 2);
        System.out.println(head);
        head=obj.reverseBetween(head, 5, 5);
        System.out.println(head);
    }
}
