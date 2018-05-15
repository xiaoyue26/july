package practice.leetcode.utils;

import org.apache.commons.lang.StringUtils;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/10/29.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(List<Integer> xs) {
        if (xs == null || xs.size() < 1) {
            throw new RuntimeException("empty input xs");
        }
        this.val = xs.get(0);
        this.next = null;
        ListNode cur = this;

        for (int i = 1; i < xs.size(); ++i) {
            cur.next = new ListNode(xs.get(i));
            cur = cur.next;
        }

    }

    @Override
    public String toString() {
        List<Integer> res = new LinkedList<>();
        ListNode cur = this;
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }
        return StringUtils.join(res, ',');
    }

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

}
