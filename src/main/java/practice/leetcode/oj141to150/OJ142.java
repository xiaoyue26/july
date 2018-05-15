package practice.leetcode.oj141to150;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/12/31.
 */
public class OJ142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast != slow) {
            return null;
        }
        while(head!=slow){
            head=head.next;
            slow=slow.next;
        }
        return head;
    }

    public static void main(String[] args) {
        OJ142 obj = new OJ142();
        ListNode head = new ListNode(Arrays.asList(
                1, 2, 3
        ));
        head.next.next = head.next;
        ListNode res = obj.detectCycle(head);
        if (res == null) {
            System.out.println("null");
        } else {
            System.out.println(res.val);
        }
    }
}
