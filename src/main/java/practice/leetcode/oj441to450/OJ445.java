package practice.leetcode.oj441to450;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiaoyue26
 */
public class OJ445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l1.val == 0) {
            return l2;
        }
        if (l2 == null || l2.val == 0) {
            return l1;
        }
        Deque<Integer> stack1 = new LinkedList<>(), stack2 = new LinkedList<>();
        ListNode cur = l1;
        while (cur != null) {
            stack1.push(cur.val);
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            stack2.push(cur.val);
            cur = cur.next;
        }
        ListNode dumpHead = new ListNode(-1);
        ListNode curNode;
        int carry = 0;
        Deque<Integer> tmpStack = stack1;
        if (stack1.size() > stack2.size()) {
            stack1 = stack2;
            stack2 = tmpStack;
        }
        // keep stack1 smaller
        while (!stack1.isEmpty()) {
            // head insert
            carry = stack1.pop() + stack2.pop() + carry;
            curNode = new ListNode(carry % 10);
            carry /= 10;
            curNode.next = dumpHead.next;
            dumpHead.next = curNode;
        }
        while (!stack2.isEmpty()) {
            carry = stack2.pop() + carry;
            curNode = new ListNode(carry % 10);
            carry /= 10;
            curNode.next = dumpHead.next;
            dumpHead.next = curNode;
        }
        while(carry!=0){
            curNode = new ListNode(carry % 10);
            carry /= 10;
            curNode.next = dumpHead.next;
            dumpHead.next = curNode;
        }


        return dumpHead.next;
    }

    public static void main(String[] args) {
        OJ445 obj = new OJ445();
        System.out.println(obj.addTwoNumbers(
                new ListNode(Arrays.asList(7, 2, 4, 3))
                , new ListNode(Arrays.asList(5, 6, 4))
        ));
        System.out.println(obj.addTwoNumbers(
                new ListNode(Arrays.asList(5))
                , new ListNode(Arrays.asList(5))
        ));
    }
}
