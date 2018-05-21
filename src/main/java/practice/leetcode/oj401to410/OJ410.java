package practice.leetcode.oj401to410;

/**
 * @author xiaoyue26
 */
public class OJ410 {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        long l = Integer.MIN_VALUE, r = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }
        long mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (valid(mid, m, nums)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }


    private boolean valid(long mid, int m, int[] nums) {
        int count = 1;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                sum = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }


        return true;
    }


    public static void main(String[] args) {
        OJ410 obj = new OJ410();
        System.out.println(obj.splitArray(new int[]{
                7, 2, 5, 10, 8
        }, 2));//18
    }
}
