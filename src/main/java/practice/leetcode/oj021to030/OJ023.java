package practice.leetcode.oj021to030;

import practice.leetcode.utils.ListNode;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/11/8.
 */
public class OJ023 {
    public static class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            return Integer.compare(o1.val, o2.val);
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            throw new NullPointerException("lists null");
        }
        if (lists.length == 0) {
            return null;
        }
        ListNode dumpHead = new ListNode(-1);
        ListNode cur = dumpHead;
        Queue<ListNode> queue = new PriorityQueue<>(new ListNodeComparator());
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.remove();
            cur.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            cur = cur.next;
        }

        return dumpHead.next;
    }

    private void mergeKLists(ListNode[] lists, ListNode pre) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (lists[i].val < min) {
                    index = i;
                    min = lists[i].val;
                }
            }
        }
        if (index != -1) {
            pre.next = lists[index];
            pre = pre.next;
            lists[index] = lists[index].next;
            mergeKLists(lists, pre);
        }
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
