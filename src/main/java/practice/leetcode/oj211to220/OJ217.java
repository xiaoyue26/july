package practice.leetcode.oj211to220;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyue26 on 18/1/24.
 */
public class OJ217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        OJ217 obj = new OJ217();
        System.out.println(obj.containsDuplicate(new int[]{
                3, 3, 2, 2, 1
        }));
    }
}
