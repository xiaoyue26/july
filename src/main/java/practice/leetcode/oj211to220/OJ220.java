package practice.leetcode.oj211to220;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 18/1/24.
 * 注1: 之所以要减去MIN,变换成非负数.
 * 因为除法分桶在0周围不均匀.
 * 为什么不均匀?
 * 因为java除法取整时候是向0取整.
 * (python是向下取整)
 */
public class OJ220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;// 注1
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }

    public static void main(String[] args) {
        OJ220 obj = new OJ220();
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{3, 1, 2, 4}, 2, 1));
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{-1, 2147483645}, 1, 2147483647));
    }
}
