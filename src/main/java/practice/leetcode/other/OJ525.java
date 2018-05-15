package practice.leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 18/1/14.
 * 0和1个数相等的连续子序列 (最大长度的一个)
 */
public class OJ525 {
    public int findMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count--;
            }
            Integer pre = map.get(count);
            if (pre != null) {
                res = Math.max(i - pre, res);
            } else {
                map.put(count, i);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        OJ525 obj = new OJ525();
        System.out.println(obj.findMaxLength(new int[]{0, 1, 0}));//2
        System.out.println(obj.findMaxLength(new int[]{0, 1}));//2
        System.out.println(obj.findMaxLength(new int[]{0, 1, 1, 1, 0, 0, 0}));//6
    }
}
