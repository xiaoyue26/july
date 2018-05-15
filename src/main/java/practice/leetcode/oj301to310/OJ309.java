package practice.leetcode.oj301to310;

/**
 * Created by xiaoyue26 on 18/2/28.
 * <p>
 * s0=max(s0,s2)  截止当前位置,处于可以买入状态
 * s1=max(s0-num,s1) 截止当前位置,处于可以卖出状态
 * s2=s1+num  截止当前位置,处于刚卖出状态
 */
public class OJ309 {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int s0[] = new int[prices.length];
        int s1[] = new int[prices.length];
        int s2[] = new int[prices.length];
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
        }

        return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
    }

    public static void main(String[] args) {
        OJ309 obj = new OJ309();
        System.out.println(obj.maxProfit(new int[]{
                1, 2, 3, 0, 2 // 3
        }));
    }
}
