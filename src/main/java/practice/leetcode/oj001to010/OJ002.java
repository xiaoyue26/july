package practice.leetcode.oj001to010;

import practice.leetcode.utils.ListNode;

import java.util.List;

/**
 * Created by xiaoyue26 on 17/10/29.
 * 2. Add Two Numbers
 */
public class OJ002 {
    public static ListNode addTwoNumbersOld(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        int sum = 0;

        while (l1 != null && l2 != null) {
            sum += l1.val + l2.val;
            result.next = new ListNode(sum % 10);
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
            sum /= 10;
        }

        while (l1 != null) {
            sum += l1.val;
            result.next = new ListNode(sum % 10);
            result = result.next;
            l1 = l1.next;
            sum /= 10;
        }
        while (l2 != null) {
            sum += l2.val;
            result.next = new ListNode(sum % 10);
            result = result.next;
            l2 = l2.next;
            sum /= 10;
        }
        if (sum != 0) {
            result.next = new ListNode(sum);
        }
        return head.next;
    }

    public static void test1() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static void test2() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode pre = null;
        ListNode head = l1;
        int carry = 0, cur;
        while (l1 != null && l2 != null) {
            cur = l1.val + l2.val + carry;
            carry = cur / 10;
            cur %= 10;
            l1.val = cur;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            pre.next = l2;
        }
        l1 = pre.next;
        while (carry > 0 && l1 != null) {
            cur = l1.val + carry;
            carry = cur / 10;
            cur %= 10;
            l1.val = cur;
            pre = l1;
            l1 = l1.next;
        }
        if (carry > 0) { // l1==null
            pre.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        test1();
        // test2();

    }
}
