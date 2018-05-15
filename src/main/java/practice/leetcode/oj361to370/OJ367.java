package practice.leetcode.oj361to370;


/**
 * @author xiaoyue26
 */
public class OJ367 {
    public boolean isPerfectSquare_newton(int num) {// 直接用牛顿法求平方根
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }

    public boolean isPerfectSquare(int num) {// 利用完全平方数都是 1+3+5...的和的特性
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        OJ367 obj = new OJ367();
        System.out.println(obj.isPerfectSquare(16));
        System.out.println(obj.isPerfectSquare(14));
        System.out.println(obj.isPerfectSquare(0));
        System.out.println(obj.isPerfectSquare(1));
    }


}
