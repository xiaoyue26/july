package practice.leetcode.oj151to160;

/**
 * Created by xiaoyue26 on 18/1/4.
 */
public class OJ153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        int mid = left + ((right - left) >> 1);
        while (left < right) {
            if (nums[mid] > nums[right]) {
                left = mid + 1;
                mid = left + ((right - left) >> 1);
            } else {//nums[mid] <= nums[right]
                if (mid - 1 >= 0) {
                    if(nums[mid-1]<nums[mid]){
                        mid=left+((mid-left)>>1);
                    }
                    else{
                        return nums[mid];
                    }
                } else {
                    return nums[mid];
                }
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        OJ153 obj = new OJ153();
        System.out.println(obj.findMin(new int[]{
                4, 5, 6, 7, 0, 1, 2
        }));
    }
}
