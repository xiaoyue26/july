package practice.leetcode.oj211to220;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 18/1/27.
 */
public class OJ220_mod {

    private long getBucketId(int x, long bucketLen) {
        return Math.floorDiv(x, bucketLen);
    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 0 || t < 0) {
            return false;
        }

        Map<Long, Integer> map = new HashMap<>();
        long bucketLen = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long id = getBucketId(nums[i], bucketLen);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1)) {
                if (Math.abs(map.get(id - 1) - (long) nums[i]) <= t) {
                    return true;
                }
            }
            if (map.containsKey(id + 1)) {
                if (Math.abs(map.get(id + 1) - (long) nums[i]) <= t) {
                    return true;
                }
            }
            map.put(id, nums[i]);
            if (i >= k) {
                map.remove(getBucketId(nums[i - k], bucketLen));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OJ220_mod obj = new OJ220_mod();
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{3, 6, 0, 4}, 2, 2));
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));
    }


}
