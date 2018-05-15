package practice.leetcode.oj321to330;


import java.util.Arrays;

/*
 *  无限硬币
 *  dp[11]=min{
 *       dp[10]
 *       ,dp[9]
 *       ,dp[6]
 *  }+1
 * **/
public class OJ322 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length < 1) {
            return -1;
        }
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (dp[i - coins[j]] != -1) {
                        if (dp[i] == -1) {
                            dp[i] = dp[i - coins[j]] + 1;
                        } else {
                            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return dp[amount];

    }

    public static void main(String[] args) {
        OJ322 obj = new OJ322();
        System.out.println(obj.coinChange(new int[]{
                1, 2, 5
        }, 11));// 3 //  11 = 5 + 5 + 1

        System.out.println(obj.coinChange(new int[]{
                2
        }, 3)); // -1
    }
}