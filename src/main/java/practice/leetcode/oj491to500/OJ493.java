package practice.leetcode.oj491to500;

import java.util.*;

/**
 * @author xiaoyue26
 * <p>
 * merge sort 解法
 */
public class OJ493 {


    public int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length - 1);
    }

    private int reversePairs(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        // after this, [left,mid] and [mid+1,right] become sorted :
        int res = reversePairs(nums, left, mid) + reversePairs(nums, mid + 1, right);
        // merge left and right
        int i = left, j = mid + 1;
        while (i <= mid) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                ++j;
            }
            res += j - (mid + 1) ;
            ++i;
        }
        merge(nums, left, mid, right);
        return res;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        if (left >= right) {
            return;
        }
        int back[] = new int[right - left + 1];
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                back[k++] = nums[i++];
            } else {
                back[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            back[k++] = nums[i++];
        }
        while (j <= right) {
            back[k++] = nums[j++];
        }
        k = 0;
        i = left;
        while (i <= right) {
            nums[i++] = back[k++];
        }
    }


    public static void main(String[] args) {
        OJ493 obj = new OJ493();
        System.out.println(obj.reversePairs(new int[]{1, 3, 2, 3, 1}));//2
        System.out.println(obj.reversePairs(new int[]{2, 4, 3, 5, 1}));//3
    }
}
