package practice.leetcode.other;

import java.util.HashMap;

/**
 * Created by xiaoyue26 on 18/1/14.
 * 有多少个连续子序列和为k
 */
public class OJ560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        OJ560 obj = new OJ560();
        System.out.println(obj.subarraySum(new int[]{1, 1, 1}, 2));//2
        System.out.println(obj.subarraySum(new int[]{1, 2, 3}, 3));//2
        System.out.println(obj.subarraySum(new int[]{-1, -1, 1}, 0));//2
    }
}
