package practice.leetcode;

import practice.leetcode.utils.PrintUtils;

/**
 * Created by xiaoyue26 on 17/12/28.
 * 有俩数出现1次,其他数出现2次.
 * 找出那俩数.
 * 1. 算出俩数的异或值diff
 * 2. 根据diff某一位1,分治原数组为两组.
 * 相同的数字会被划分到同一组.
 *
 * 二进制操作笔记:
 * (0) 相反数: 位取反+1; -a = (~a)+1
 * (1) 只获取最右边的1.  a&(-a);
 * (2) 抹去最右边的1,保留其他位:  a&(a-1)
 */
public class OJ260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        int res[] = new int[]{0, 0};
        for (int num : nums) {
            diff ^= num;
        }
        // 找某一位1. 最方便的是找最右边的1.
        diff -= diff & (diff - 1); // 或 diff = diff&(-diff)
        for (int num : nums) {
            if ((diff & num) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        OJ260 obj = new OJ260();
        PrintUtils.print(obj.singleNumber(new int[]{1, 2, 1, 3, 2, 5}));//3,5

        for (int i = 0; i < 16; i++) {
            int res = i - (i & (i - 1));
            System.out.println(res);
        }
        System.out.println(5^2);


    }
}
