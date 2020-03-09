package practice.leetcode.oj001to010;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 17/10/29.
 * 1. Two Sum
 */
public class OJ001 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            Integer preIndex = map.get(target - nums[i]);
            if (preIndex != null) {
                return new int[]{preIndex, i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 1};
    }

    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
        //String[] aaa = new String[]{"1", "1", "1"};
        int target = 13;
        for (int i : twoSum(num, target)) {
            System.out.println(i);
        }


    }
}
