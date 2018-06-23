package practice.leetcode.oj451to460;

/**
 * @author xiaoyue26
 */
public class OJ453 {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] - min;
        }

        return res;

    }

    public static void main(String[] args) {
        OJ453 obj = new OJ453();
        System.out.println(obj.minMoves(new int[]{
                1, 2, 3
        }));// 3
    }
}
