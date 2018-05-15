package practice.leetcode.oj291to300;

import java.util.Arrays;

/**
 * Created by jiuzhoumu on 2018/2/20.
 * dp[i] i+1长度的自序列，最后一个数字（最大的数）是几。
 */
public class OJ300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;// 更新dp某一位
            if (i == len) {//如果正好在末尾，append子序列，可以增加长度
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        OJ300 obj = new OJ300();
        System.out.println(obj.lengthOfLIS(new int[]{
                10, 9, 2, 5, 3, 7, 101, 18//2, 3, 7, 101
        }));
    }
}
