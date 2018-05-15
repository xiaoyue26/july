package practice.leetcode.oj121to130;

/**
 * Created by xiaoyue26 on 17/12/21.
 */
public class OJ122 {
    public int maxProfit(int[] prices) {
        int profile = 0;
        if (prices == null || prices.length < 2) {
            return profile;
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profile += prices[i] - prices[i - 1];
            }
        }

        return profile;
    }

    public static void main(String[] args) {
        OJ122 obj = new OJ122();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(obj.maxProfit(prices));
    }
}
