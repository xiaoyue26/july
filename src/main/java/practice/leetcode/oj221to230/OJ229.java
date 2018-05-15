package practice.leetcode.oj221to230;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by xiaoyue26 on 18/1/31.
 * 出现次数大于 n/3
 * time: O(n)  // 2n时间或者3n时间
 * space: O(1)
 */
public class OJ229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // k = 3, n=k-1=2
        int num1 = -1, num2 = -2; // 竞争者
        int count1 = 0, count2 = 0;// 计数器
        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            } else if (count1 == 0) { // 试图取代num1
                num1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 1;
            } else { // 一损俱损
                count1--;
                count2--;
            }
        }

        return Stream.of(num1, num2).filter(num -> {
            int count = 0;
            for (int n : nums) {
                if (n == num) {
                    count++;
                }
            }
            return count > nums.length / 3;
        }).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        OJ229 obj = new OJ229();
        System.out.println(obj.majorityElement(new int[]{0, 1, 2, 4, 2, 5, 2, 7}));// 2
        System.out.println(obj.majorityElement(new int[]{0, 1, 2, 1, 2, 1, 2, 7}));// 2,1
    }
}
