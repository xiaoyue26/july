package practice.leetcode.oj031to040;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/16.
 */
public class OJ031 {
    public void nextPermutation(int[] nums) {
        int i;
        int j;
        for (i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                j = findFirstBigger(nums, i, nums[i - 1]);
                swap(nums, j, i - 1);
                reverse(nums, i, nums.length - 1);
                return;
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        int mid = begin + (end - begin) / 2;
        for (int i = begin, j = end; i <= mid; i++, j--)
            swap(nums, i, j);
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int findFirstBigger(int[] nums, int head, int cur) {
        for (int j = nums.length - 1; j >= head; --j) {
            if (nums[j] > cur) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        OJ031 obj = new OJ031();
        int nums[] = {1, 3, 2, 4};
        for (int i = 0; i < 5; i++) {
            obj.nextPermutation(nums);
            for (int n : nums) {
                System.out.print(n + ",");
            }
            System.out.println();
        }

    }
}
