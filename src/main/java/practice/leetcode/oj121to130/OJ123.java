package practice.leetcode.oj121to130;

/**
 * Created by xiaoyue26 on 17/12/22.
 */
public class OJ123 {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for (int i : prices) { // 4种状态转移.
            release2 = Math.max(release2, hold2 + i); // release2由hold2转移过来.
            hold2 = Math.max(hold2, release1 - i);
            release1 = Math.max(release1, hold1 + i);
            hold1 = Math.max(hold1, 0-i);// hold1由初始0元开始,买下当天的.
        }
        return release2;
    }

    public static void main(String[] args) {
        OJ123 obj = new OJ123();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(obj.maxProfit(prices));
    }
}
