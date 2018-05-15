package practice.leetcode.oj351to360;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xiaoyue26
 * <p>
 * 俄罗斯套娃
 * 最多能嵌套多少层
 * <p>
 * 排序然后按height找LIS(最大增子序列)的长度
 * dp[index]: 长度为index+1的序列的最小结尾
 * dp[i] i+1长度的自序列，最后一个数字（最大的数）最小是几。（见oj300）
 */
public class OJ354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2) {
            return 0;
        }
        Arrays.sort(envelopes, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) { // 宽度升序
                return arr2[1] - arr1[1];
            } else {// 高度降序
                return arr1[0] - arr2[0];
            }
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelope[1];// height
            if (index == len) { // 更新最大长度
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        OJ354 obj = new OJ354();
        System.out.println(obj.maxEnvelopes(new int[][]{
                {5, 4}
                , {6, 4}
                , {6, 7}
                , {2, 3}
        }));// 3 // [2,3]=>[5,4]=>[6,7]

    }
}
