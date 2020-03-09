package practice.leetcode.oj021to030;

/**
 * Created by xiaoyue26 on 17/11/13.
 */
public class OJ029 {


    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0 || divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }

        boolean flag = true;
        if (dividend > 0) {
            flag = false;
            dividend = -dividend;
        }
        if (divisor > 0) {
            flag = !flag;
            divisor = -divisor;
        }
        int res = 0;
        int part_res;
        int x;
        while (divisor >= dividend) {
            x = divisor;
            part_res = 1;
            while (x > dividend
                    && x > (x << 1) // 防止x溢出
                    && (x << 1) > dividend // 保持part_res和x停下来时是正确值,省得在之后再除以2
                    ) {
                part_res <<= 1;// part_res*=2;
                x <<= 1;// x*=2;
            }
            res += part_res;
            dividend -= x;
        }
        if (flag) {
            return res;
        }
        return -res;
    }

    public int divide_old(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (divisor == 1)
            return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            else
                return -dividend;
        }
        boolean flag = true;
        if (dividend > 0) {
            flag = false;
            dividend = -dividend;// 保持被除数是负数
        }
        if (divisor > 0) {
            flag = !flag;
            divisor = -divisor; // 保持除数也是负数
        }
        int a = dividend, b = divisor, tmp = 1, result = 0;
        // dividend<0 and divisor<0 now: 如果用正数的话,绝对值会溢出,用负数就没问题了.
        while (a <= b) {
            while (a <= b && a < (b << 1) && (b << 1) < b) {// 找到最接近的幂
                b <<= 1;
                tmp <<= 1;
            }
            a -= b;
            result += tmp;
            b = divisor;
            tmp = 1;
        }
        if (flag)
            return result;
        else
            return -result;
    }

    public static void main(String[] args) {
        OJ029 obj = new OJ029();
        int dividend = -2147483648;
        int divisor = 2;
       /* int dividend = -5;
        int divisor = -2;*/
        System.out.println(obj.divide(dividend, divisor));
    }
}
