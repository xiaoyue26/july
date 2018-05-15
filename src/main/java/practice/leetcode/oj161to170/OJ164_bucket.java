package practice.leetcode.oj161to170;


import java.util.Arrays;

/**
 * Created by xiaoyue26 on 18/1/6.
 */
public class OJ164_bucket {
    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        // find min,max
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        // construct buckets
        int n = nums.length;
        double tmp = (double) (max - min) / (n - 1);
        int bucketSize = (int) Math.ceil(tmp);
        int[] bucketMin = new int[n - 1];
        int[] bucketMax = new int[n - 1];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        // collect min,max for each bucket

        for (int num : nums) {
            if (num == min || num == max) {
                continue;
            }
            int index = (num - min) / bucketSize;
            bucketMax[index] = Math.max(bucketMax[index], num);
            bucketMin[index] = Math.min(bucketMin[index], num);
        }
        int maxGap = Integer.MIN_VALUE;
        int pre = min;
        for (int i = 0; i < bucketMax.length; i++) {
            if (bucketMax[i] == Integer.MIN_VALUE) {
                continue;// empty bucket
            }
            int curGap = bucketMin[i] - pre;
            maxGap = Math.max(curGap, maxGap);
            pre = bucketMax[i];
        }
        maxGap = Math.max(max - pre, maxGap);
        return maxGap;
    }

    public static void main(String[] args) {
        OJ164_bucket obj = new OJ164_bucket();
        System.out.println(obj.maximumGap(new int[]{
                3, 8, 2
        }));
    }
}
