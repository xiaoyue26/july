package practice.leetcode.oj161to170;

import practice.leetcode.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaoyue26 on 18/1/6.
 * 基数排序有两种:
 * LSD : 最低位优先. 从最低位开始排到最高位,结果是最高位起决定性作用.
 * MSD:  最高位优先
 */
public class OJ164_radix {
    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int exp = 1;
        final int radix = 10;
        int[] aux = new int[nums.length];
        int[] count = new int[radix];
        while (max / exp > 0) {// 基数排序
            Arrays.fill(count, 0);// 计数器清零
            for (int i = 0; i < nums.length; i++) {// 计数排序
                int id = (nums[i] / exp) % 10; // 当前处理位
                count[id]++; // 处理位等于i的元素有几个.
            }
            for (int i = 1; i < radix; i++) { // i: 1->9. // count[i]: (处理位)小于等于i的元素有几个.
                count[i] += count[i - 1];// 这样仅看计数器的值就能知道座次了.
            }
            //for (int i = 0; i < nums.length; ++i) {  // 正序错误
            for (int i = nums.length - 1; i >= 0; --i) { // 为什么倒序处理? 见注1. 仅适用于计数排序.
                int id1 = (nums[i] / exp) % 10; // 当前处理位,第几个计数器.
                int id = --count[id1];
                aux[id] = nums[i];
            }

            for (int i = 0; i < nums.length; i++) {// 导回原数组.
                nums[i] = aux[i];
            }
            exp *= 10;
        }
        PrintUtils.print(nums);
        int maxGap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxGap = Math.max(nums[i + 1] - nums[i], maxGap);
        }
        return maxGap;
    }

    public static void main(String[] args) {
        OJ164_radix obj = new OJ164_radix();
        System.out.println(obj.maximumGap(new int[]{
                // 63, 18, 32
                //15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740
                11, 13, 12
        }));
    }
    /*
    原因: 为了不浪费上一轮的计数排序工作.
    假设nums在上一轮中已经有序(按低位),
    倒序第一个就是最大的一个.
    由于用的是计数排序,当前位相同的元素富集到同一个计数器上,先处理的这一轮会在这个计数器元素的最后面. (--count[i])
    所以倒序处理的话, 刚好能和计数排序接轨.
    * */
}
