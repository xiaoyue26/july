package practice.leetcode.oj341to350;

/*
* 平方差公式
* 4^n - 1 = (2^n + 1) * (2^n - 1)
* 前提： 连续三个数，必有一个是3的倍数。
*
* (1) 证明4^n - 1是3的倍数。
* 考虑三个数: 2^n-1,2^n,2^n+1
* 其中2^n必定不是，因此, 4^n-1 必是3的倍数。
*
* (2) 证明2^(2k+1)-1不是3的倍数。
*
* 因为：2^(2K+1)-1=4^k*2-1= (3m+1)*2-1=6m+1
* => [2^(2k+1)-1] %3 = 1
* */
public class OJ342 {
    public boolean isPowerOfFour(int num) {
        if (num < 0) {
            return false;
        }
        if ((num & (num - 1)) != 0) {
            return false;
        }

        return (num - 1) % 3 == 0;
    }

    public static void main(String[] args) {
        OJ342 obj = new OJ342();
        System.out.println(obj.isPowerOfFour(16));
        System.out.println(obj.isPowerOfFour(5));
        System.out.println(obj.isPowerOfFour(8));
    }
}