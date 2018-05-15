package practice.leetcode.oj161to170;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 18/1/6.
 * 无序非负数组,返回有序排列时最大间隔. 要求O(n)
 */
public class OJ164 {
    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        // 算最大最小值. 确定桶的边界.
        int min = nums[0];
        int max = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // 计算理论上的min(最大间隔). (均匀间隔时) 对均匀分隔任意数改变,都会让一个间隔增大,另一个间隔减小,因此导致最大间隔增大.
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));

        // n-1个桶. 每个桶长度为gap. 所有数字根据自身的范围落到某个桶里. n个数字=>n-1个桶. 最少有俩数字在一个桶里.
        int[] bucketsMIN = new int[nums.length - 1];// 每个桶里的最小值.
        int[] bucketsMAX = new int[nums.length - 1];// 每个桶里的最大值.
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        // put numbers into buckets
        for (int numi : nums) {
            if (numi == min || numi == max)
                continue;
            int idx = (numi - min) / gap; // index of the right position in the
            // buckets
            bucketsMIN[idx] = Math.min(numi, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(numi, bucketsMAX[idx]);
        }
        // 计算最大间隔
        int maxGap = Integer.MIN_VALUE;
        int pre = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE) {
                continue;// 跳过空桶
            }
            // pre:上一个桶的最大值 -> 这个桶的最小值
            maxGap = Math.max(maxGap, bucketsMIN[i] - pre);
            pre = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - pre); // do last
        return maxGap;
    }

    public static void main(String[] args) {
        OJ164 obj = new OJ164();
        System.out.println(obj.maximumGap(new int[]{
                3, 8, 2
        }));
    }
}
