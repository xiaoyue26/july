package practice.leetcode.oj021to030;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/11/11.
 */
public class OJ025_test {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) {
            return head;
        }
        ListNode dumpHead = new ListNode(-1);
        ListNode pre = dumpHead, nextHead = head;

        ListNode cur, tmp, nextPre;
        while (true) {
            // 1. check k step:
            for (int i = 0; i < k; i++) {
                if (nextHead != null) {
                    nextHead = nextHead.next;
                } else {
                    pre.next = head;
                    return dumpHead.next;
                    // return head;
                }
            }
            // 头插+为下一次做准备:
            nextPre = head;
            for (int i = 0; i < k; i++) {
                cur = pre.next;
                pre.next = head;
                tmp = head.next;
                head.next = cur;
                head = tmp;
            }
            nextPre.next = null;
            pre = nextPre;
        }
    }

    public static void main(String[] args) {
        OJ025_test obj = new OJ025_test();
        ListNode head = new ListNode(Arrays.asList(1, 2, 3, 4));
        head = obj.reverseKGroup(head, 4);
        System.out.println(head);
        head = obj.reverseKGroup(head, 4);
        System.out.println(head);
        head = obj.reverseKGroup(head, 2);
        System.out.println(head);
        head = obj.reverseKGroup(head, 3);
        System.out.println(head);

    }
}
