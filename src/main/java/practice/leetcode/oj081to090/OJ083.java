package practice.leetcode.oj081to090;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/12/7.
 * sorted list dedup. leave one .
 */
public class OJ083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val != pre.val) {
                pre.next=cur;
                pre = cur;
            }
            cur = cur.next;
            pre.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        OJ083 obj = new OJ083();
        ListNode head = new ListNode(Arrays.asList(
                //1, 1, 2, 3, 3
                1,1,2
        ));
        System.out.println(obj.deleteDuplicates(head));
    }
}
