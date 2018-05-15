package practice.leetcode.oj081to090;

/**
 * Created by xiaoyue26 on 17/12/6.
 */
public class OJ081 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (target < nums[mid]) {// 找更小的
                if (nums[left] < nums[mid]) { // 左有序,右边可能有更小的
                    if (nums[left] < target) {// go left
                        right = mid - 1;
                    } else if (nums[left] > target) {// go right
                        left = mid + 1;
                    } else {// =
                        return true;
                    }
                } else if (nums[left] > nums[mid]) { // go left 左无序,右边不可能有更小的
                    right = mid - 1;
                } else {// nums[left] == nums[mid] 从left到mid一直相等或者从mid到right一直相等
                    while (left <= mid && nums[left] == nums[mid]) {
                        left++;
                    }
                }

            } else if (target > nums[mid]) {// 找更大的
                if (nums[left] < nums[mid]) { // 左有序,左边不可能有更大的
                    left = mid + 1;
                } else if (nums[left] > nums[mid]) {// 右有序
                    if (nums[right] < target) {// go left
                        right = mid - 1;
                    } else if (nums[right] > target) {// go right
                        left = mid + 1;
                    } else {// =
                        return true;
                    }
                } else { // nums[left] == nums[mid]
                    while (left <= mid && nums[left] == nums[mid]) {
                        left++;
                    }
                }
            } else {
                return true;
            }

        }


        return false;
    }

    public static void main(String[] args) {
        OJ081 obj = new OJ081();
        int nums[] = {4, 5, 6, 7, 0, 1, 1, 2};
        for (int i = -1; i < 9; i++) {
            System.out.println(i + ":" + obj.search(nums, i));
        }
    }
}