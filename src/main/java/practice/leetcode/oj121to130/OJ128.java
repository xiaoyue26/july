package practice.leetcode.oj121to130;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 17/12/24.
 */
public class OJ128 {
    public int longestConsecutive(int[] nums) {
        // 包含key的线段的长度. // 重点保证左边界或者右边界的正确性
        Map<Integer, Integer> boundMap = new HashMap<>();
        int res = 0;
        for (int cur : nums) {
            if (boundMap.containsKey(cur)) {
                continue;
            }
            // 获取左右线段的长度.
            int left = boundMap.getOrDefault(cur - 1, 0);
            int right = boundMap.getOrDefault(cur + 1, 0);
            int sum = left + right + 1;
            res = Math.max(sum, res);
            boundMap.put(cur, sum);
            // 更新左右边界长度
            boundMap.put(cur - left, sum);
            boundMap.put(cur + right, sum);
        }

        return res;
    }

    public static void main(String[] args) {
        OJ128 obj = new OJ128();
        int nums[] = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(obj.longestConsecutive(nums));
    }
}
