package practice.leetcode.oj061to070;

/**
 * Created by xiaoyue26 on 17/12/2.
 */
public class OJ070 {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int dp0=1;
        int dp1=2;
        int i = 2;
        while (i < n) {
            dp0 = dp0 + dp1;
            ++i;
            if (i >= n) {
                return dp0;
            }
            dp1 = dp0 + dp1;
            ++i;
        }

        return dp1;
    }

    public static void main(String[] args) {
        OJ070 obj = new OJ070();
        System.out.println(obj.climbStairs(1));
        System.out.println(obj.climbStairs(2));
        System.out.println(obj.climbStairs(3));
        System.out.println(obj.climbStairs(4));
    }
}
