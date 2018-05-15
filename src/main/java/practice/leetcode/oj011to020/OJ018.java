package practice.leetcode.oj011to020;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/11/5.
 */
public class OJ018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> threeRess = threeSum(nums, i + 1, nums.length - 1, target - nums[i]);
            for (List<Integer> threeRes : threeRess) {
                List<Integer> r = new ArrayList<>();
                r.add(nums[i]);
                r.addAll(threeRes);
                res.add(r);
            }

        }

        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int begin, int end, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || end - begin < 2) {
            return res;
        }
        Arrays.sort(nums);
        //int i = 0, j = nums.length - 1, k;
        for (int i = begin; i <= end - 2; i++) {
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = end; j >= i + 2; j--) {
                if (j < end && nums[j] == nums[j + 1]) {
                    continue;
                }
                int num1 = nums[i];
                int num2 = nums[j];
                int num3 = target - num1 - num2;
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
        OJ018 obj = new OJ018();
        int nums[] = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(obj.fourSum(nums, target));
    }
}
