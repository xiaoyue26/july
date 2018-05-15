package practice.leetcode.oj271to280;

/**
 * Created by jiuzhoumu on 2018/2/12.
 */
public class OJ279 {
    public int numSquares(int n) {
        if (n <= 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
            if (i * i + 1 <= n) {
                dp[i * i + 1] = 2;
            }
        }
        int min;
        for (int i = 3; i <= n; i++) {
            if (dp[i] != 0) {
                continue;
            }
            min = Integer.MAX_VALUE;
            for (int j = 1; j <= i / 2; j++) {
                min=Math.min(dp[j]+dp[i-j],min);
                if(min==2){
                    break;
                }
            }
            dp[i]=min;

        }


        return dp[n];
    }

    public static void main(String[] args) {
        OJ279 obj = new OJ279();
        System.out.println(obj.numSquares(13));// 4 9
        System.out.println(obj.numSquares(12));// 4 4 4
    }
}
