package practice.leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 18/1/14.
 * 连续子序列和=k的倍数
 */
public class OJ523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();// key: 截止value位置的和; value: 截止位置index.
        map.put(0, -1);// 截止-1位置和为0. // 应对 nums=[0,0],k=0的特殊情况
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            Integer pre = map.get(sum);// [0,i]-[0,pre]= n*k = (pre,i]
            if (pre != null) {
                if (i - pre > 1) return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OJ523 obj = new OJ523();
        System.out.println(obj.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6)); // 6
        System.out.println(obj.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6)); // 42
    }
}
