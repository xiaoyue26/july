package practice.leetcode.oj021to030;

/**
 * Created by xiaoyue26 on 17/11/12.
 */
public class OJ027 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int tail;
        if (nums[0] != val) {
            tail = 0;
        } else {
            tail = -1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[++tail] = nums[i];
            }
        }
        return tail + 1;

    }

    public static void main(String[] args) {
        OJ027 obj = new OJ027();
        int nums[] = {2, 3, 3, 2};
        int val = 3;
        int len = obj.removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
