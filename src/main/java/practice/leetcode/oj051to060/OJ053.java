package practice.leetcode.oj051to060;

/**
 * Created by xiaoyue26 on 17/11/26.
 */
public class OJ053 {
    public int maxSubArray_dp(int[] nums) {
        int len = nums.length;
        if (len < 1)
            return Integer.MIN_VALUE;
        int dp[] = new int[len];
        int max = dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] >= 0)
                dp[i] = dp[i - 1] + nums[i];
            else
                dp[i] = nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArray_divide(int[] nums) {
        return divideandconquer(nums, 0, nums.length - 1);
    }
    private int divideandconquer(int[] nums, int left, int right) {
        if (left > right)
            return 0;
        if (left == right)
            return nums[left];
        int max;
        if (left + 1 == right) {
            max = Math.max(nums[left], nums[right]);
            max = Math.max(nums[left] + nums[right], max);
            return max;
        }
        // divide,left:
        int mid = (left + right) / 2;
        int leftmax = nums[mid - 1], rightmax = nums[mid + 1], sum = leftmax, i;
        for (i = mid - 2; i >= left; --i) {
            sum += nums[i];
            leftmax = Math.max(leftmax, sum);
        }
        // right:
        sum = rightmax;
        for (i = mid + 2; i <= right; ++i) {
            sum += nums[i];
            rightmax = Math.max(rightmax, sum);
        }
        // merge:
        sum = leftmax + rightmax + nums[mid];
        leftmax = divideandconquer(nums, left, mid);
        rightmax = divideandconquer(nums, mid, right);
        max = Math.max(leftmax, rightmax);
        max = Math.max(max, sum);
        return max;
    }

    // 简单的贪心解:
    public int maxSubArray(int[] nums) {
        int res = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (res < 0) {
                res = nums[i];
            } else {
                res += nums[i];
            }
            if (res > max) {
                max = res;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        OJ053 obj = new OJ053();
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};//6
        System.out.println(obj.maxSubArray(nums));
    }


}
