package practice.leetcode.oj021to030;

/**
 * Created by xiaoyue26 on 17/11/12.
 */
public class OJ026 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int tail = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[tail]) {
                nums[++tail] = nums[i];
            }
        }
        return tail + 1;
    }

    public static void main(String[] args) {
        OJ026 obj = new OJ026();
        int[] nums = {1, 1, 1, 2, 2};
        int len = obj.removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }
}
