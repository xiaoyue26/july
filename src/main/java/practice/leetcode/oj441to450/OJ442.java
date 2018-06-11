package practice.leetcode.oj441to450;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoyue26
 */
public class OJ442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int valueIndex;
        for (int i = 0; i < nums.length; i++) {
            valueIndex = Math.abs(nums[i]) - 1;
            if (nums[valueIndex] > 0) {
                nums[valueIndex] *= -1;
            } else {
                res.add(valueIndex + 1);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        OJ442 obj = new OJ442();
        System.out.println(obj.findDuplicates(new int[]{
                4, 3, 2, 7, 8, 2, 3, 1
        }));// 2,3
    }
}
