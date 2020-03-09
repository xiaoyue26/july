package practice.leetcode.oj031to040;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xiaoyue26 on 17/11/18.
 */
public class OJ035 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {// ==
                return mid;
            }
        }
        return left; // insert point
    }

    public static void main(String[] args) {
        OJ035 obj = new OJ035();
        int nums[] = {1, 3, 6, 7, 10};

        for (int num = 0; num < 13; ++num) {
            System.out.print(num + ",");
            System.out.print(obj.searchInsert(nums, num));
            int tmp = Arrays.binarySearch(nums, num);
            System.out.println("," + (tmp >= 0 ? tmp : -tmp - 1));
        }

    }
}
