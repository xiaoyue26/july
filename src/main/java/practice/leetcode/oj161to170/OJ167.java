package practice.leetcode.oj161to170;

import practice.leetcode.utils.PrintUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 18/1/7.
 * nums 有序
 * 返回的index是1-based.
 * <p>
 * 每个输入有且仅有一个solution.
 * 每个元素最多用1次.
 */
public class OJ167 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
            int pre = target - nums[i];
            if (pre != nums[i]) {
                if (map.containsKey(pre)) {
                    int index = map.get(pre);
                    return new int[]{index, i + 1};
                }
            } else if(i>0){
                if(nums[i-1]==pre){
                    return new int[]{i, i + 1};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        OJ167 obj = new OJ167();
        int nums[] = new int[]{2, 7, 11, 15};
        PrintUtils.print(obj.twoSum(nums, 9));//1,2
        PrintUtils.print(obj.twoSum(new int[]{2, 3, 4}, 6));//1,3
        PrintUtils.print(obj.twoSum(new int[]{0, 0, 3, 4}, 0));//1,3
    }
}
