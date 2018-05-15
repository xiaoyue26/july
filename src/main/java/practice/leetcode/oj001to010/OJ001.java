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
        int[] index = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            int rest = target - nums[i];
            if (map.containsKey(rest)) {
                index[0] = map.get(rest);
                index[1] = i;
                return index;
            } else {
                map.put(nums[i], i);
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
        //String[] aaa = new String[]{"1", "1", "1"};
        int target = 4;
        for (int i : twoSum(num, target)) {
            System.out.println(i);
        }


    }
}
