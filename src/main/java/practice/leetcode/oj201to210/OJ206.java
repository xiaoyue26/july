package practice.leetcode.oj201to210;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 18/1/18.
 */
public class OJ206 {
    public ListNode reverseList(ListNode head) {
        ListNode dump = new ListNode(-1);
        ListNode tmp;

        while (head != null) {
            tmp=dump.next;
            dump.next=head;
            head=head.next;
            dump.next.next=tmp;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        OJ206 obj = new OJ206();
        System.out.println(obj.reverseList(new ListNode(Arrays.asList(
                3, 2, 1
        ))));
    }
}
