package practice.leetcode.oj071to080;

import practice.leetcode.utils.PrintUtils;


/**
 * Created by xiaoyue26 on 17/12/3.
 */
public class OJ075 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int tail0 = 0, head2 = nums.length - 1;
        int cur = 0;
        while (cur <= head2) {
            if (nums[cur] == 0) {
                //if (tail0 != cur) {
                swap(nums, cur, tail0);
                //}
                tail0++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, head2);
                head2--;
            } else {
                cur++;
            }

        }


    }

    private void swap(int[] nums, int x, int y) {
        if (x != y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
    }

    public static void main(String[] args) {
        OJ075 obj = new OJ075();
        int[] nums = {1, 0};
        obj.sortColors(nums);
        PrintUtils.print(nums);

    }
}
