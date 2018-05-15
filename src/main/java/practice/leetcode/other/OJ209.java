package practice.leetcode.other;

/**
 * Created by xiaoyue26 on 18/1/14.
 */
public class OJ209 {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        if (res != Integer.MAX_VALUE) {
            return res;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        OJ209 obj = new OJ209();
        System.out.println(obj.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));// 2 : [4,3]
    }
}
