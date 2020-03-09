package practice.leetcode.oj001to010;

/**
 * Created by xiaoyue26 on 17/11/3.
 */
public class OJ007 {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        OJ007 obj = new OJ007();
        System.out.println(obj.reverse(-321));
        System.out.println(obj.reverse(120));
        System.out.println(obj.reverse(123));
        int res = obj.reverse(-1000000003);
        System.out.println(res);
        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(Integer.MIN_VALUE / 10);
        System.out.println((-1) % 10);
    }
}
