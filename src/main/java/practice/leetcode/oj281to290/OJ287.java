package practice.leetcode.oj281to290;

/**
 * Created by jiuzhoumu on 2018/2/16.
 * 1 ~ n => int[n+1]
 */
public class OJ287 {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        OJ287 obj = new OJ287();
        System.out.println(obj.findDuplicate(new int[]{
                3, 1, 2, 1
        }));
    }
}
