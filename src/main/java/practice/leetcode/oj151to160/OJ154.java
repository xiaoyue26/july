package practice.leetcode.oj151to160;

/**
 * Created by xiaoyue26 on 18/1/4.
 */
public class OJ154 {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];

    }

    public static void main(String[] args) {
        OJ154 obj = new OJ154();
        System.out.println(obj.findMin(new int[]{
                2, 2, 2, 2, 2, 1, 2, 2, 2
        }));
    }
}
