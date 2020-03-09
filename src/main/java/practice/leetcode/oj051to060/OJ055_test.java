package practice.leetcode.oj051to060;

/**
 * Created by xiaoyue26 on 17/11/27.
 */
public class OJ055_test {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int rightMost = 0;
        for (int i = 0; i <= rightMost && i < nums.length; i++) {
            rightMost = Math.max(i + nums[i], rightMost);
        }
        return rightMost >= nums.length - 1;
    }


    public static void main(String[] args) {
        OJ055_test obj = new OJ055_test();
        int nums[] = {2, 3, 1, 1, 4};
        System.out.println(obj.canJump(nums));//true
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(obj.canJump(nums2));//false
    }
}
