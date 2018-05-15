package practice.leetcode.oj211to220;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 18/1/26.
 */
public class OJ220_new {
    public static long ceilDiv(long x, long y){
        return -Math.floorDiv(-x,y);
    }
    private long getID(long i, long w) {
        /*if (i < 0) {
            return ((i + 1) / w) - 1;
        } else {
            return i / w;
        }*/
        return Math.floorDiv(i, w);// 这样也可以. // 向下取整.
        //return i < 0 ? (i + 1) / w - 1 : i / w; // 向下取整.
        // return ceilDiv(i,w); 向上取整也可以.
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            if (d.containsKey(m))
                return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            d.put(m, (long) nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }

    public static void main(String[] args) {
        OJ220_new obj = new OJ220_new();
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{-1, 2147483645}, 1, 2147483647));
        System.out.println((-1)/2);
        System.out.println((-3)/2);

    }
}
