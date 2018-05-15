package practice.leetcode.oj031to040;

/**
 * Created by xiaoyue26 on 17/11/17.
 */
public class OJ033 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        int mid;// = left + ((right - left) >> 1);


        while (right > left + 1) {
            mid = left + ((right - left) >> 1);

            if (target < nums[mid]) { // 找小的
                if (nums[mid] > nums[left]) { // left,mid OK
                    if (target > nums[left]) { // in left,mid
                        right = mid - 1;
                        continue;
                    } else if (target < nums[left]) {// in mid,right
                        left = mid + 1;
                        continue;
                    } else {
                        return left;
                    }
                } else { // left , mid rotate
                    right = mid - 1;
                }
            } else if (target > nums[mid]) {// 找大的
                if (nums[mid] < nums[right]) { // mid,right OK
                    if (target < nums[right]) { // in mid,right
                        left = mid + 1;
                    } else if (target > nums[right]) {// in left,mid
                        right = mid - 1;
                    } else {
                        return right;
                    }
                } else { // mid,right rotate
                    left = mid + 1;
                }
            } else {// 相等
                return mid;

            }
        }

        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        OJ033 obj = new OJ033();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        //int[] nums = {5, 1, 2, 3, 4};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(obj.search(nums, nums[i]));
        }

        System.out.println("=========================");
        System.out.println(obj.search(nums, 8));
        System.out.println(obj.search(nums, -1));
        System.out.println(obj.search(nums, 3));


        int left = 1, right = 2;

        int mid = left + ((right - left) >> 1);
        //System.out.println(mid);


    }
}
