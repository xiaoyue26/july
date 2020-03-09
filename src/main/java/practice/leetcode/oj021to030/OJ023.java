package practice.leetcode.oj021to030;

import practice.leetcode.utils.ListNode;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/11/8.
 */
public class OJ023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        for (ListNode l : lists) {
            if (l != null) heap.offer(l);
        }
        ListNode dumpHead = new ListNode(-1);
        ListNode pre = dumpHead, cur;
        while (!heap.isEmpty()) {
            cur = heap.poll();
            pre.next = cur;
            if (heap.isEmpty()) {
                break; // quick out
            }
            pre = cur;
            if (cur.next != null) {
                heap.offer(cur.next);
            }
        }
        return dumpHead.next;
    }

    public static void main(String[] args) {
        OJ023 obj = new OJ023();
        ListNode l1 = new ListNode(Arrays.asList(1, 3, 5));
        ListNode l2 = new ListNode(Arrays.asList(2, 4, 6));
        ListNode l3 = new ListNode(Arrays.asList(0, 9));
        ListNode l4 = null;
        ListNode l5 = new ListNode(1);
        ListNode[] lists = new ListNode[]{l1, l2, l3, l4, l5};
        ListNode[] lists2 = new ListNode[0];
        System.out.println(obj.mergeKLists(lists));
        /*ListNode l6=new ListNode(1);
        ListNode l7=null;
        ListNode[]ll=new ListNode[]{l6,l7};
        Arrays.sort(ll,new ListNode.ListNodeComparator());*/

    }
}
