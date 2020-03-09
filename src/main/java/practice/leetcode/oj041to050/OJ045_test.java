package practice.leetcode.oj041to050;


/**
 * Created by xiaoyue26 on 17/11/22.
 */
public class OJ045_test {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int count = 0, curRight = 0, nextRight = nums[0];
        for (int i = 1; i < nums.length && curRight < nums.length - 1; i++) {
            if (i > curRight) {
                curRight = nextRight;
                count += 1;
            }
            nextRight = Math.max(nextRight, i + nums[i]);
        }


        return count;
    }

    public static void main(String[] args) {
        OJ045_test obj = new OJ045_test();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(obj.jump(nums));
    }
}
