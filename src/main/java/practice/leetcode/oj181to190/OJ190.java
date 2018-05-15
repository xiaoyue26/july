package practice.leetcode.oj181to190;

import practice.leetcode.utils.PrintUtils;

/**
 * Created by xiaoyue26 on 18/1/13.
 */
public class OJ190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 0) {
                res <<= 1;
            } else {
                res <<= 1;
                res += 1;
            }
            n>>>=1;
        }

        return res;
    }


    public static void main(String[] args) {
        OJ190 obj = new OJ190();
        System.out.println(obj.reverseBits(43261596));//964176192
    }
}
