package practice.leetcode.oj011to020;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/11/5.
 */
public class OJ018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                twoSum(nums, j + 1, target, res, nums[i], nums[j]);
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int begin, int target, List<List<Integer>> res, int first, int second) {
        int i = begin, j = nums.length - 1;
        while (i < j) {
            if (i > begin && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int curRes = nums[i] + nums[j] + first + second;
            if (curRes > target) {
                --j;
            } else if (curRes < target) {
                ++i;
            } else {// curRes = target
                res.add(Arrays.asList(
                        first, second, nums[i], nums[j]
                ));
                ++i;
                --j;
            }
        }

    }

    public static void main(String[] args) {
        OJ018 obj = new OJ018();
        int nums[] = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(obj.fourSum(nums, target));
    }
}
