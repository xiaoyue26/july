package practice.leetcode.oj231to240;

import practice.leetcode.utils.ListNode;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 18/2/3.
 * O(n)时间, O(1)空间
 * 修改了链表以后,记得改回去.
 */
public class OJ234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast, slow, dump = new ListNode(-1);
        dump.next = head;
        fast = head;
        slow = dump;
        ListNode tmp, newHead = new ListNode(-1);
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (slow != dump) {
                tmp = newHead.next;
                newHead.next = slow;
                slow = slow.next;
                newHead.next.next = tmp;
            } else {
                slow = slow.next;
            }
        }
        // eat tail slow:
        tmp = newHead.next;
        newHead.next = slow;
        slow = slow.next;
        newHead.next.next = tmp;
        // walk more 1 for odd
        ListNode mid = null;
        if (fast != null) {// 奇数
            mid = slow;
            slow = slow.next;
        }
        fast = newHead.next;
        newHead.next = null;
        ListNode backFast = fast;
        ListNode backSlow = slow;
        boolean flag = true;
        while (fast != null) {
            if (fast.val != slow.val) {
                flag = false;
            }
            slow = slow.next;
            tmp = newHead.next;
            newHead.next = fast;
            fast = fast.next;
            newHead.next.next = tmp;
        }
        if (mid != null) {
            backFast.next = mid;
            backFast = mid;
        }
        backFast.next = backSlow;
        return flag;
    }

    public static void main(String[] args) {
        OJ234 obj = new OJ234();
        ListNode head = new ListNode(Arrays.asList(
                1, 2, 2, 1
                //1,2,1
        ));
        System.out.println(obj.isPalindrome(head));
        System.out.println(head);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo ti : threadInfos) {
            System.out.println(ti.getThreadId() + ":" + ti.getThreadName());
        }
        synchronized (OJ234.class) {

            System.out.println("hello world");
        }

    }
}
