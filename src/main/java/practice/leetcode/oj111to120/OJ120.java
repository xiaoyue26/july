package practice.leetcode.oj111to120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/21.
 * min path down
 * O(n)空间. 倒序会省去minLastRow那个变量.
 */
public class OJ120 {


    private boolean inRange(int[] dp, int i, int left, int right) {
        if (i >= left && i < dp.length && i <= right) {
            return true;
        }
        return false;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int dp[] = new int[n * (1 + n) / 2];
        int i = 0;
        dp[i++] = triangle.get(0).get(0);
        int minLastRow=dp[i-1];
        for (int j = 1; j < triangle.size(); j++) {
            int left = j * (j - 1) / 2;
            int right = j * (j + 1) / 2 - 1;
            minLastRow=Integer.MAX_VALUE;
            for (Integer cur : triangle.get(j)) {
                int tmp = Integer.MAX_VALUE;
                if (inRange(dp, i - j, left, right)) {
                    tmp = dp[i - j] + cur;
                }
                if (inRange(dp, i - j - 1, left, right)) {
                    tmp = Math.min(dp[i - j - 1] + cur, tmp);
                }
                dp[i++] = tmp;
                minLastRow=Math.min(minLastRow,dp[i-1]);
            }
        }


        return minLastRow;
    }

    public static void main(String[] args) {
        OJ120 obj = new OJ120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(obj.minimumTotal(triangle));// 11
    }
}
