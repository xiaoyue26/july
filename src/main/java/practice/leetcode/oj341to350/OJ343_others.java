package practice.leetcode.oj341to350;

/*
 * 2*(f-2) = 2f-4 >= f
 * 直接优先用3做因子.
 * 其次用2。
 * */
public class OJ343_others {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        product *= n;

        return product;
    }

    public static void main(String[] args) {
        OJ343_others obj = new OJ343_others();
        System.out.println(obj.integerBreak(2)); // 1 // 1+1
        System.out.println(obj.integerBreak(8)); // 18 // 2*2*3
        System.out.println(obj.integerBreak(10)); // 36  // 3+3+4
    }
}