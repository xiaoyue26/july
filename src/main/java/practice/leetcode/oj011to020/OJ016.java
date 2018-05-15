package practice.leetcode.oj011to020;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xiaoyue26 on 17/11/5.
 */
public class OJ016 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int gap = target - nums[0] - nums[1] - nums[2];
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = nums.length - 1; j >= i + 2; --j) {
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                int num1 = nums[i];
                int num2 = nums[j];
                int num3 = target - num1 - num2;
                if (num3 > num2) {
                    int curGap = num3 - nums[j - 1];
                    if (Math.abs(curGap) < Math.abs(gap)) {
                        gap = curGap;
                    }
                    break;
                } else if (num3 < num1) {
                    int curGap = num3 - nums[i + 1];
                    if (Math.abs(curGap) < Math.abs(gap)) {
                        gap = curGap;
                    }
                    continue;
                } else { // num1<=num3<=num2
                    int curGap = minGap(nums, i + 1, j - 1, num3);
                    if (curGap == 0) {
                        return target;
                    }
                    if (Math.abs(curGap) < Math.abs(gap)) {
                        gap = curGap;
                    }
                }
            }
        }
        return target - gap;
    }

    private int minGap(int[] nums, int begin, int end, int num) {
        int gap = Integer.MAX_VALUE;
        if (begin > end) {
            return gap;
        }
        // 2分查找
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            int curGap = num - nums[mid];
            if (curGap == 0) {
                return 0;
            }
            if (Math.abs(curGap) < Math.abs(gap)) {
                gap = curGap;
            }
            if (nums[mid] < num) {
                begin = mid + 1;
            } else if (nums[mid] > num) {
                end = mid - 1;
            }
        }
        return gap;
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
        int mid = (Integer.MAX_VALUE+ Integer.MAX_VALUE) >>> 1;
        System.out.println(mid);
        System.out.println(Integer.MAX_VALUE+ Integer.MAX_VALUE);
        System.out.println(((-1)>>2));
        System.out.println(((-1)>>>1));
    }
}
