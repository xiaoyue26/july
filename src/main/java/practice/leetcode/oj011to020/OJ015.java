package practice.leetcode.oj011to020;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/11/5.
 * 三个数加起来等于0
 */
public class OJ015 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i + 1, 0 - nums[i], res);
        }
        return res;
    }

    private void twoSum(int[] nums, int begin, int target, List<List<Integer>> res) {
        int i = begin, j = nums.length - 1;
        while (i < j) {
            if (i > begin && nums[i] == nums[i - 1]) {
                ++i;
                continue;
            }
            if (nums[i] + nums[j] > target) {
                --j;
            } else if (nums[i] + nums[j] < target) {
                ++i;
            } else {
                res.add(Arrays.asList(nums[begin - 1], nums[i], nums[j]));
                ++i;
                --j;
            }
        }

    }

    public static void main(String[] args) {
        OJ015 obj = new OJ015();
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0, 0, 0, 0};
        System.out.println(obj.threeSum(nums));
    }
}
