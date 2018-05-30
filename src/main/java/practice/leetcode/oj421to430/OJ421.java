package practice.leetcode.oj421to430;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaoyue26
 * a^b=c => a^c=b, b^c=a
 */
public class OJ421 {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int nextMax = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(nextMax ^ prefix)) {// 存在能达到nextMax的前缀
                    max = nextMax;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        OJ421 obj = new OJ421();
        System.out.println(obj.findMaximumXOR(new int[]{
                3, 10, 5, 25, 2, 8
        }));
    }
}
