package practice.leetcode.oj011to020;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xiaoyue26 on 17/11/5.
 */
public class OJ016 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int rest = target - nums[i];
            int tmp = twoSumClosest(nums, i + 1, nums.length - 1, rest);
            if (tmp == rest) {
                return target;
            }
            if (Math.abs(tmp + nums[i] - target) < minGap) {
                minGap = Math.abs(tmp + nums[i] - target);
                res = tmp + nums[i];
            }
        }

        return res;
    }

    private int twoSumClosest(int[] nums, int begin, int end, int target) {
        int minGap = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        int i = begin, j = end, k;
        while (i < j) {
            k = nums[i] + nums[j];
            if (Math.abs(k - target) < minGap) {
                minGap = Math.abs(k - target);
                res = nums[i] + nums[j];
            }
            if (k > target) {
                --j;
            } else if (k < target) {
                ++i;
            } else { // (k == target)
                return target;
            }


        }
        return res;
    }

    public static void main(String[] args) {
        OJ016 obj = new OJ016();
        int[] nums = {-1, 2, 1, -4};
        //int[] nums = {0, 0, 0};
        int target = 1;
        System.out.println(obj.threeSumClosest(nums, target));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.abs(Integer.MAX_VALUE));
        System.out.println(Long.MAX_VALUE);
        System.out.print("mid:");
        int mid = (Integer.MAX_VALUE + Integer.MAX_VALUE) >>> 1;
        System.out.println(mid);
        System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);
        System.out.println(((-1) >> 2));
        System.out.println(((-1) >>> 1));
    }
}
