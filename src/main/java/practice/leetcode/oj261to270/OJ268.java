package practice.leetcode.oj261to270;

/**
 * Created by jiuzhoumu on 2018/2/10.
 */
public class OJ268 {
    public int missingNumber_sum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = (nums.length + 1) * (nums.length) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= nums[i];
            res ^= i;
        }
        res ^= nums.length;
        return res;
    }

    public static void main(String[] args) {
        OJ268 obj = new OJ268();
        System.out.println(obj.missingNumber(new int[]{
                0, 1, 3
        }));

    }
}
