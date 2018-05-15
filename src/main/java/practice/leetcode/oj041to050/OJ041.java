package practice.leetcode.oj041to050;

/**
 * Created by xiaoyue26 on 17/11/20.
 */
public class OJ041 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 >= 0 && nums[i] - 1 < nums.length && nums[i] - 1 != i
                    && nums[nums[i] - 1]-1!=nums[i] - 1
                    ) {
                tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        OJ041 obj = new OJ041();
        int nums[] = {1, 2, 0};//3
        int nums2[] = {3, 4, -1, 1};//2
        int nums3[] = {1, 1};//2
       System.out.println(obj.firstMissingPositive(nums));
        System.out.println(obj.firstMissingPositive(nums2));
       System.out.println(obj.firstMissingPositive(nums3));
    }

}
