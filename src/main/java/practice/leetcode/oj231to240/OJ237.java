package practice.leetcode.oj231to240;

import practice.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 18/2/5.
 * 删除当前节点.
 * 非常诡异的题目.
 */
public class OJ237 {
    public void deleteNode(ListNode node) {// 把自己伪装成下一个节点,并且删除下一个节点.
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        OJ237 obj = new OJ237();
        ListNode node = new ListNode(Arrays.asList(1, 2, 3, 4));
        obj.deleteNode(node);

    }
}
