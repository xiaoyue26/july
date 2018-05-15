package practice.leetcode.oj041to050;

/**
 * Created by xiaoyue26 on 17/11/25.
 */
public class OJ050 {
    public double myPow_old(double x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n == 0 || x == 1) {
            return 1;
        }

        if (x == -1) {
            if (n % 2 == 1) {

                return -1;
            } else {
                return 1;
            }
        }

        boolean flagn = false;


        if (n < 0) {
            flagn = true;
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
            } else {
                n = -n;
            }

        }
        double tmpX = x;
        int tmpN = 1;
        double res = 1;

        while (n > 0) {
            while ((tmpN << 1) <= n && (tmpN << 1) > tmpN) {
                tmpX *= tmpX;
                tmpN <<= 1;
            }
            res *= tmpX;
            n -= tmpN;
            tmpN = 1;
            tmpX = x;

        }


        if (flagn) {
            return 1 / res;
        } else {
            return res;
        }
    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return myPow(1 / x, Integer.MAX_VALUE) / x;
            } else {
                return myPow(1 / x, -n);
            }

        }
        if (n % 2 == 1) {
            return myPow(x * x, n / 2) * x;
        } else {
            return myPow(x * x, n / 2);
        }

    }

    public static void main(String[] args) {
        OJ050 obj = new OJ050();
        System.out.println(obj.myPow(2.00, 10));
        System.out.println(obj.myPow(-2.00, 10));
        System.out.println(obj.myPow(-2.00, -10));
        System.out.println(obj.myPow(2.00, -10));
        System.out.println(obj.myPow(2.10, 3));
        System.out.println(obj.myPow(2.10, 1));
        System.out.println(obj.myPow(0.00001, -2147483648));
    }


}
