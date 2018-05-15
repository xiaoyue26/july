package practice.leetcode.oj151to160;

/**
 * Created by xiaoyue26 on 18/1/3.
 */
public class OJ152 {
    public int maxProduct_old(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int dpMax[] = new int[nums.length];// 以i结尾的最大值
        int dpMin[] = new int[nums.length];// 以i结尾的最小值
        int res = nums[0];
        dpMin[0] = dpMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], nums[i]);
            dpMax[i] = Math.max(dpMin[i - 1] * nums[i], dpMax[i]);
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], nums[i]);
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], dpMin[i]);
            res = Math.max(res, dpMax[i]);
        }

        return res;
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int dpMax;// 以i结尾的最大值
        int dpMin;// 以i结尾的最小值
        int res;
        dpMin = dpMax = res = nums[0];
        int tmpMin, tmpMax;
        for (int i = 1; i < nums.length; i++) {
            tmpMax = dpMax;
            tmpMin = dpMin;
            dpMax = Math.max(tmpMax * nums[i], nums[i]);
            dpMax = Math.max(tmpMin * nums[i], dpMax);
            dpMin = Math.min(tmpMin * nums[i], nums[i]);
            dpMin = Math.min(tmpMax * nums[i], dpMin);
            res = Math.max(res, dpMax);
        }

        return res;
    }

    public static void main(String[] args) {
        OJ152 obj = new OJ152();
        System.out.println(obj.maxProduct(new int[]{
                2, 3, -2, 4 // 6
        }));
    }
}
