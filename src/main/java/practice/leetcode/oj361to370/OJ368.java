package practice.leetcode.oj361to370;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiaoyue26
 * 求一个集合，两两能整除，要求长度最大。
 * 先排序后dp
 */
public class OJ368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];//记录从0~i包括nums[i]的最大subset的size
        int[] pre = new int[n];//记录到当前元素最大size的前一位数的下标
        Arrays.sort(nums);
        int max = 0, index = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {// nums[i]%nums[j]==0 => nums[i]%前面的也==0 (因为nums[j]%前面的==0)
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {//找到最大的子集size 和它最后元素的下标
                max = count[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) { //回溯解集
            res.add(nums[index]);
            index = pre[index];
        }
        return res;

    }

    public static void main(String[] args) {
        OJ368 obj = new OJ368();
        System.out.println(obj.largestDivisibleSubset(new int[]{
                1, 2, 3
        }));// [1,2] // or [1,3]
        System.out.println(obj.largestDivisibleSubset(new int[]{
                1, 2, 4, 8
        }));// [1,2,4,8]
    }
}
