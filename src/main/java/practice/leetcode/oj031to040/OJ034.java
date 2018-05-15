package practice.leetcode.oj031to040;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xiaoyue26 on 17/11/18.
 */
public class OJ034 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else { // reach the range
                int l = findLeft(nums, left, mid, target);
                int r = findRight(nums, mid, right, target);
                return new int[]{l, r};
            }
        }


        return new int[]{-1, -1};
    }

    private int findRight(int[] nums, int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                if (nums[mid - 1] == target) {
                    return mid - 1;
                } else if (nums[mid - 1] > target) {
                    right = mid - 2;
                }
            } else { // nums[mid]==target
                if (mid + 1 > right || nums[mid + 1] > target) {
                    return mid;
                } else { // ==
                    left = mid + 1;
                }
            }
        }

        return left;
    }

    private int findLeft(int[] nums, int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                if (nums[mid + 1] == target) {
                    return mid + 1;
                } else {
                    left = mid + 1;
                }
            } else { // target == nums[mid]
                if (mid - 1 < left || nums[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }

        return left;
    }

    public static void main(String[] args) {
        OJ034 obj = new OJ034();
        int nums[] = {5, 7, 7, 8, 8, 10};
        int target = 1;
        int[] res = obj.searchRange(nums, target);
        List<Integer> rr = Arrays.stream(res).boxed().collect(Collectors.toList());
        System.out.println(rr);
    }
}
