package practice.leetcode.oj201to210;

/**
 * Created by xiaoyue26 on 18/1/20.
 * 找>=s的序列
 */
public class OJ209 {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, left = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                minLen = Math.min(minLen, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }
        return minLen;
    }

    public static void main(String[] args) {
        OJ209 obj = new OJ209();
        System.out.println(obj.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
