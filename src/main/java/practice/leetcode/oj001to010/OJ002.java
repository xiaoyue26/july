package practice.leetcode.oj001to010;

import practice.leetcode.utils.ListNode;

/**
 * Created by xiaoyue26 on 17/10/29.
 * 2. Add Two Numbers
 */
public class OJ002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

    /*private static ListNode long2node(long num) {
        ListNode l = new ListNode(0);
        l.next = new ListNode(0);
        ListNode dumpHead = l;
        long rest = num;// 也可以直接用num
        while (rest > 0) {
            l.next = new ListNode( (int)rest % 10);
            l = l.next;
            rest = rest / 10;
        }

        return dumpHead.next;
    }

    private static long node2long(ListNode l1) {
        long sum = 0;
        long level = 0;
        while (l1 != null) {
            sum += Math.pow(10, level) * l1.val;
            level+=1;
            l1 = l1.next;
        }
        return sum;
    }

    public static void test1(){// long不够长,装不下这么大的list 9999999991
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(l1, l2);
        System.out.println(node2long(res));
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }*/
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

    public static void main(String[] args) {
        test1();
        //test2();

    }
}
