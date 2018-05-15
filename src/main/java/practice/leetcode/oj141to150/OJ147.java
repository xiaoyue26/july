package practice.leetcode.oj141to150;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 18/1/2.
 */
public class OJ147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dump = new ListNode(-1);
        ListNode pre, cur = head, tmp;
        while (cur != null) {
            pre = dump;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            tmp = pre.next;
            pre.next = cur;
            cur = cur.next;
            head.next = tmp;
            head = cur;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        OJ147 obj = new OJ147();
        ListNode head = new ListNode(Arrays.asList(
                //1, 2, 6, 5, 4
                 3,2,1,4,5,7
        ));
        System.out.println(obj.insertionSortList(head));
    }
}
