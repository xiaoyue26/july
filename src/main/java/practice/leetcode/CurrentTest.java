package practice.leetcode;


import practice.leetcode.utils.ListNode;

import java.util.*;

/**
 * @author xiaoyue26
 */
public class CurrentTest {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode dumpHead = new ListNode(-1);

        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, (a, b) -> {
            if (a == null) {
                return 1;
            } else if (b == null) {
                return -1;
            } else {
                return a.val - b.val;
            }
        });
        for (ListNode l : lists) {
            if (l != null) {
                heap.offer(l);
            }
        }
        ListNode curPre = dumpHead;
        while (!heap.isEmpty()) {
            curPre.next = heap.poll();
            if (heap.isEmpty()) {
                break; // quick out
            }
            curPre = curPre.next;
            if (curPre.next != null) {
                heap.offer(curPre.next);
            }
        }
        return dumpHead.next;
    }


    public static void main(String[] args) {
        CurrentTest obj = new CurrentTest();
        ListNode[] list = new ListNode[]{
                new ListNode(Arrays.asList(1, 4, 5))
                , new ListNode(Arrays.asList(1, 3, 4))
                , new ListNode(Arrays.asList(2, 6))
        };
        /** 1->4->5,
         1->3->4,
         2->6*/
        // 1->1->2->3->4->4->5->6
        System.out.println(obj.mergeKLists(list));
    }

}
