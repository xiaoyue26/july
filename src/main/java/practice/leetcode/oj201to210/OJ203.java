package practice.leetcode.oj201to210;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 18/1/16.
 */
public class OJ203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode cur = dump;
        while (head != null) {
            if (head.val != val) {
                cur.next = head;
                cur=cur.next;
            }
            head = head.next;
            cur.next=null;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        OJ203 obj = new OJ203();
        ListNode head = new ListNode(Arrays.asList(
                1, 2, 6, 3, 4, 5, 6//1,2,3,4,5
        ));
        System.out.println(obj.removeElements(head, 6));
    }
}
