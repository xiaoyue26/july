package practice.leetcode.oj341to350;

public class OJ343 {
    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int left = j;
                int right = i - j;
                if (dp[left] > left) {
                    left = dp[left];
                }
                if (dp[right] > right) {
                    right = dp[right];
                }
                dp[i] = Math.max(dp[i], left * right);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        OJ343 obj = new OJ343();
        System.out.println(obj.integerBreak(2)); // 1 // 1+1
        System.out.println(obj.integerBreak(8)); // 18 // 2*2*3
        System.out.println(obj.integerBreak(10)); // 36  // 3+3+4

    }
}