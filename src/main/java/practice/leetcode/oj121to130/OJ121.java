package practice.leetcode.oj121to130;

/**
 * Created by xiaoyue26 on 17/12/21.
 * 最大的(后-前)
 */
public class OJ121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int left, profit = 0;
        left = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > left)
                profit = Math.max(profit, prices[i] - left);
            else {// prices[i]<=left
                // change left
                left = prices[i];
            }

        }
        return profit;
    }

    public static void main(String[] args) {
        OJ121 obj = new OJ121();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(obj.maxProfit(prices));
    }
}
