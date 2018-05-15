package practice.leetcode.oj381to390;

import practice.leetcode.utils.PrintUtils;

import java.util.Random;

/**
 * @author xiaoyue26
 */
public class OJ384 {

    private final int nums[];
    private final Random random;

    public OJ384(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] res = new int[nums.length];
        int r;
        for (int i = 0; i < nums.length; i++) {
            r = random.nextInt(i + 1);
            res[i] = res[r];
            res[r] = nums[i];
        }


        return res;
    }

    public static void main(String[] args) {
        OJ384 obj = new OJ384(new int[]{1, 2, 3});
        PrintUtils.print(obj.reset());
        PrintUtils.print(obj.shuffle());
    }
}
