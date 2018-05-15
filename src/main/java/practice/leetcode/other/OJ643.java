package practice.leetcode.other;

/**
 * Created by xiaoyue26 on 18/1/14.
 */
public class OJ643 {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        int sum = 0;
        int res;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }

        return (double) res / k;
    }

    public static void main(String[] args) {
        OJ643 obj = new OJ643();
        System.out.println(obj.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));// 12.75
    }
}
