package practice.leetcode.oj431to440;

/**
 * @author xiaoyue26
 */
public class OJ440 {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k -= 1;
        while (k > 0) {
            int steps = calSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr += 1;
                k -= steps;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }

    //use long in case of overflow
    public int calSteps(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }

    public static void main(String[] args) {
        OJ440 obj = new OJ440();
        System.out.println(obj.findKthNumber(13, 2));// 10
        // 1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9

    }
}
