package practice.leetcode.oj381to390;

/**
 * @author xiaoyue26
 */
public class OJ390 {
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }

    public static void main(String[] args) {
        OJ390 obj = new OJ390();
        System.out.println(obj.lastRemaining(9));//6
        System.out.println(obj.lastRemaining(3));//2
    }
}
