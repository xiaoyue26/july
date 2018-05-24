package practice.leetcode.oj411to420;

import practice.leetcode.utils.PrintUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiaoyue26
 */
public class OJ414 {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Queue<Integer> heap = new PriorityQueue<>(nums.length, (o1, o2) -> -o1.compareTo(o2));
        heap.addAll(numList);
        if (heap.size() < 3) {
            return heap.poll();
        }
        int count = 1;
        int max = heap.poll();
        int pre = max, cur = pre;
        while (count <= 2 && heap.size() > 0) {
            cur = heap.poll();
            if (cur != pre) {
                count++;
                pre = cur;
            }
        }
        if (count >= 3) {
            return pre;
        }

        return max;

    }

    public int thirdMax_others(int[] nums) {
        long m1 = Integer.MIN_VALUE-1L, m2 = m1, m3 = m2;
        for(int i=0; i < nums.length; i++){
            if(m1 == nums[i] || m2 == nums[i])
                continue;
            if(m1 < nums[i]){
                m3 = m2;
                m2 = m1;
                m1 = nums[i];
            }else if(m2 < nums[i]){
                m3 = m2;
                m2 = nums[i];
            }else
                m3 = Math.max(m3, nums[i]);
        }
        return (int) (m3 == Integer.MIN_VALUE-1L ? m1 : m3);
    }

    public static void main(String[] args) {
        OJ414 obj = new OJ414();
        System.out.println(obj.thirdMax(new int[]{
                2, 2, 3, 1
        }));// 1
        System.out.println(obj.thirdMax(new int[]{
                1, 2, 5, 3, 5
        }));// 2
    }
}
