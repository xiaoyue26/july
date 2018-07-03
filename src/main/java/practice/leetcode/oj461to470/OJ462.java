package practice.leetcode.oj461to470;

/**
 * @author xiaoyue26
 */

import java.util.Arrays;

public class OJ462 {
    // 中位数优于均值
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int count = 0;
        for (int n : nums) {
            count += Math.abs(n - median);
        }
        return count;
    }

    public static void main(String[] args) {
        OJ462 obj = new OJ462();
        System.out.println(obj.minMoves2(new int[]{
                1, 2, 3, 4
        }));
        System.out.println(obj.minMoves2(new int[]{
                1, 2, 3
        }));
        System.out.println(obj.minMoves2(new int[]{
                1, 0, 0, 8, 6
        }));
    }
}