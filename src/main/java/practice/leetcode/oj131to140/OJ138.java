package practice.leetcode.oj131to140;

import practice.leetcode.utils.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 17/12/29.
 * deep copy
 * 还有一种方法是扫3遍,额外空间只有O(1).
 */
public class OJ138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> weHave = new HashMap<>();
        return copyRandomList(head, weHave);// dfs
    }

    private RandomListNode copyRandomList(RandomListNode head, Map<RandomListNode, RandomListNode> weHave) {
        if (head == null) {
            return null;
        }
        if (weHave.containsKey(head)) {
            return weHave.get(head);
        }
        RandomListNode res = new RandomListNode(head.label);
        weHave.put(head, res);
        res.next = copyRandomList(head.next, weHave);
        res.random = copyRandomList(head.random, weHave);
        return res;
    }

    public static void main(String[] args) {
        OJ138 obj = new OJ138();

        System.out.println("there");
    }
}
