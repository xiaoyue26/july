package practice.leetcode.oj231to240;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 18/2/5.
 * 不能用除法.
 * O(n) 时间
 * O(1) 空间
 * dp
 */
public class OJ238 {
    public int[] productExceptSelf(int[] nums) {// 左右各扫一遍
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1; // 左边所有数的总乘积,(不含当前)
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1; // 右边所有数的乘积
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        OJ238 obj = new OJ238();
        obj.productExceptSelf(new int[]{1, 2, 3, 4});//24,12,8,6
        System.out.println("there");
    }
}
