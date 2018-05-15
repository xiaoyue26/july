package practice.leetcode.oj381to390;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author xiaoyue26
 * 谷歌一致性哈希里用的跳变,不过这里是链表,只能用第一形态
 */
public class OJ382 {
    ListNode head;
    Random random;

    public OJ382(ListNode h) {
        head = h;
        random = new Random();
    }

    public int getRandom() {

        ListNode c = head;
        int r = c.val;
        for (int i = 1; c.next != null; i++) {
            c = c.next;
            if (random.nextInt(i + 1) == i) r = c.val;
        }

        return r;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        OJ382 obj = new OJ382(head);

        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
    }
}
