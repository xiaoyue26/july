package practice.leetcode.oj231to240;

/**
 * Created by xiaoyue26 on 18/2/2.
 * 判断是否是2的幂
 * 二进制只有一个1
 */
public class OJ231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0 || n == Integer.MIN_VALUE) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        OJ231 obj = new OJ231();
        System.out.println(obj.isPowerOfTwo(1));
        System.out.println(obj.isPowerOfTwo(2));
        System.out.println(obj.isPowerOfTwo(4));
        System.out.println(obj.isPowerOfTwo(6));
        System.out.println(obj.isPowerOfTwo(8));
        System.out.println(obj.isPowerOfTwo(1024));
    }
}
