package practice.leetcode.oj041to050;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/11/22.
 */
public class OJ045 {
    public int jump(int[] nums) {
        int count = 0; // 目前走了几步
        int curEnd = 0;// 在count步下,最右边能到哪里
        int maxBefore = nums[0];// 不管步数,最右边能到哪里
        for (int i = 1; i < nums.length && curEnd < nums.length - 1; ++i) {
            if (i > curEnd) {
                curEnd = maxBefore;
                count++;
            }
            //if (maxBefore >= i) { // 如果不一定能到最后,就要加上这句
            maxBefore = Math.max(maxBefore, i + nums[i]);
            //}
        }
        return count;
    }

    public static void main(String[] args) {
        OJ045 obj = new OJ045();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(obj.jump(nums));
    }
}
