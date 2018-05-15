package practice.leetcode.oj331to340;

import practice.leetcode.utils.PrintUtils;

/*
 * 00 => 0
 * 01 => 1
 * 10 => 1
 * 11 => 2
 *100 => 1
 *101 => 2
 *
 * dp一下： res[i]=res[i>>>1]+{0,1}
 * 除以2或者无符号右移
 * */
public class OJ338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 0) {
                res[i] = res[i >>> 1];
            } else {
                res[i] = res[i >>> 1] + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OJ338 obj = new OJ338();
        PrintUtils.print(obj.countBits(5)); // 0,1,1,2,1,2
    }
}