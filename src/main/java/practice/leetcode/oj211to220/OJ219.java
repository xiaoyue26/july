package practice.leetcode.oj211to220;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 18/1/24.
 */
public class OJ219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int pre = map.get(nums[i]);
                if (i - pre <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        OJ219 obj = new OJ219();
        System.out.println(obj.containsNearbyDuplicate(new int[]{3, 1, 2, 3, 2, 0}, 3));
    }
}
