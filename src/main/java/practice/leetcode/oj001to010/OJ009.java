package practice.leetcode.oj001to010;

/**
 * Created by xiaoyue26 on 17/11/4.
 */
public class OJ009 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        if (x % 10 == 0)
            return false;

        int y = 0;
        while (x > y) {
            y = 10 * y + x % 10;
            x /= 10;
        }
        if (x == y || x == y / 10)
            return true;
        return false;

    }

    public boolean isPalindrome2(int x) {
        if (x < 0)
            return false;
        if (x >= 0 && x < 10)
            return true;
        int top = 1;
        while (x / top >= 10) {
            top *= 10;
        }
        while (x > 0) {
            if (x / top != x % 10) return false;
            //remove head and tail
            x %= top;
            x /= 10;
            top /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        OJ009 obj = new OJ009();
        System.out.println(obj.isPalindrome(131));
        System.out.println(obj.isPalindrome2(131));
        System.out.println(obj.isPalindrome(1331));
        System.out.println(obj.isPalindrome2(1331));
        System.out.println(obj.isPalindrome(121));
        System.out.println(obj.isPalindrome(-121));
        System.out.println(obj.isPalindrome(10));
        System.out.println(obj.isPalindrome(101));
        System.out.println(obj.isPalindrome(1010));
        System.out.println(obj.isPalindrome(0));
    }
}
