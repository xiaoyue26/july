package practice.leetcode.oj211to220;

/**
 * Created by xiaoyue26 on 18/1/21.
 */
public class OJ213 {

    private int rob(int[] num, int left, int right) {
        int include = 0, exclude = 0;
        int preIn, preEx;
        for (int i = left; i <= right; i++) {
            preIn = include;
            preEx = exclude;
            include = preEx + num[i];// 不使用pre的总最大值 + 当前值 = 使用当前值的最大值.
            exclude = Math.max(preEx, preIn); // 不使用当前值的最大值.
        }
        return Math.max(include, exclude);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        // 0和len-1不能同时使用,所以可能性有俩: [0,len-2],[1,len-1]
        return Math.max(rob(nums, 0, nums.length - 2)
                , rob(nums, 1, nums.length - 1));
    }

    public static void main(String[] args) {
        OJ213 obj = new OJ213();
        System.out.println(obj.rob(new int[]{
        }));
        System.out.println(obj.rob(new int[]{3, 1000, 1, 1, 1000, 9, 2}));
    }
}
