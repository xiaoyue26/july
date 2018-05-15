package practice.leetcode.oj121to130;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xiaoyue26 on 17/12/22.
 */
public class OJ125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        Deque<Character> res = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if (Character.isLetterOrDigit(cur)) {
                res.offer(Character.toLowerCase(cur));
            }
        }
        while (res.size() > 1) {
            Character head = res.pollFirst();
            Character tail = res.pollLast();
            if (!head.equals(tail)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OJ125 obj = new OJ125();
        System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(obj.isPalindrome("race a car"));

    }
}
