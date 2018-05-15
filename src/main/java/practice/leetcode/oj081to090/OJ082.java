package practice.leetcode.oj081to090;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/12/6.
 * sorted list dedup. leave 0.
 */
public class OJ082 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumpHead = new ListNode(-1);
        ListNode pre = null;
        ListNode cur = head;
        ListNode tail = dumpHead;

        while (cur != null) {
            // 1. check pre
            if (pre == null || pre.val != cur.val) {
                // 2 . check next
                if (cur.next == null || cur.next.val != cur.val) {
                    tail.next = cur;
                    tail = cur;
                }
            }
            pre = cur;
            cur = cur.next;
            tail.next=null;
        }
        return dumpHead.next;
    }

    public static void main(String[] args) {
        OJ082 obj = new OJ082();
        ListNode head = new ListNode(Arrays.asList(
                1, 2, 3, 3, 4, 4, 5
                //1,1,1,1,3,4,5
                //1,2,2
        ));
        System.out.println(obj.deleteDuplicates(head));//1,2,5
    }
}
