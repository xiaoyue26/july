package practice.leetcode.oj051to060;

/**
 * Created by xiaoyue26 on 17/11/27.
 */
public class OJ055 {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public boolean canJump_old(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        int maxBefore = nums[0];
        int curEnd = 0;
        int count = 0;
        for (int i = 1; i < nums.length && curEnd < nums.length - 1; i++) {
            if (i > curEnd) {
                curEnd = maxBefore;
                count++;
            }
            if (maxBefore >= i) {
                maxBefore = Math.max(maxBefore, i + nums[i]);
            }
        }
        if(curEnd >= nums.length - 1){
            System.out.println(count);
            return true;
        }
        System.out.println(count);
        return false;
    }

    public static void main(String[] args) {
        OJ055 obj = new OJ055();
        int nums[] = {2, 3, 1, 1, 4};
        System.out.println(obj.canJump(nums));//true
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(obj.canJump(nums2));//false
    }
}
