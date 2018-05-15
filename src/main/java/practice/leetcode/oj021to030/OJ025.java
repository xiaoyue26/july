package practice.leetcode.oj021to030;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/11/11.
 */
public class OJ025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) {
            return head;
        }

        ListNode dumpHead = new ListNode(-1);
        ListNode cur = dumpHead;
        ListNode next = head.next;
        ListNode nextGroupHead;
        ListNode nextCur;
        int i;
        while (head != null) {
            nextGroupHead = head;
            for (i = 0; i < k && nextGroupHead != null; i++) {
                nextGroupHead = nextGroupHead.next;
            }
            if (i < k) { // rest node < k
                // connect rest:
                cur.next = head;
                break;
            }
            // reverse [head,nextGroupHead)
            nextCur = head;
            for (i = 0; i < k - 1; ++i) {
                next = head.next;
                head.next = cur.next;
                cur.next = head;
                head = next;
            }
            // handle k :
            head.next = cur.next;
            cur.next = head;
            // move cur and head
            cur = nextCur;
            head = nextGroupHead;
        }


        return dumpHead.next;
    }

    public static void main(String[] args) {
        OJ025 obj = new OJ025();
        ListNode head = new ListNode(Arrays.asList(1, 2, 3, 4));
        System.out.println(obj.reverseKGroup(head, 2));
    }
}
