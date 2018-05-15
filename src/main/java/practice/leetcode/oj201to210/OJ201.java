package practice.leetcode.oj201to210;

/**
 * Created by xiaoyue26 on 18/1/15.
 */
public class OJ201 {
    public int rangeBitwiseAnd(int m, int n) {
        int gap = n - m;
        int res = m&n;
        int k = 0xFFFFFFFE;
        while (gap > 0) {
            res &= k;
            gap >>= 1;
            k <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        OJ201 obj = new OJ201();
        System.out.println(obj.rangeBitwiseAnd(5, 7));//4
        System.out.println(obj.rangeBitwiseAnd(4, 6));//4
        System.out.println(obj.rangeBitwiseAnd(1, 2));//0
        System.out.println(obj.rangeBitwiseAnd(3, 4));//0
    }
}
