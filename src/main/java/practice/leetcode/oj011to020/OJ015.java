package practice.leetcode.oj011to020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/5.
 * 三个数加起来等于0
 */
public class OJ015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        //int i = 0, j = nums.length - 1, k;
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = nums.length - 1; j >= i + 2; j--) {
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                int num1 = nums[i];
                int num2 = nums[j];
                int num3 = 0 - num1 - num2;
                if (num3 > num2) {
                    break;
                }
                if (num3 < num1) {
                    continue;
                }
                if (findNum(nums, i + 1, j - 1, num3)) {
                    res.add(Arrays.asList(num1, num3, num2));
                }
            }
        }

        return res;
    }

    private boolean findNum(int[] nums, int begin, int end, int num) {
        if (begin > end) {
            return false;
        }
        // 2分查找
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] < num) {
                begin = mid + 1;
            } else if (nums[mid] > num) {
                end = mid - 1;
            }
            if (nums[mid] == num) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        OJ015 obj = new OJ015();
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0, 0, 0, 0};
        System.out.println(obj.threeSum(nums));
    }
}
