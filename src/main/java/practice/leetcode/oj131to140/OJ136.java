package practice.leetcode.oj131to140;

/**
 * Created by xiaoyue26 on 17/12/28.
 */
public class OJ136 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        OJ136 obj = new OJ136();
        int nums[] = new int[]{1, 2, 2, 1, 3};
        System.out.println(obj.singleNumber(nums));
    }
}
