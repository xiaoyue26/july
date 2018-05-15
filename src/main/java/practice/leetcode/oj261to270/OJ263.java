package practice.leetcode.oj261to270;

/**
 * Created by xiaoyue26 on 18/2/9.
 * 1 => true
 * 6,8 => true (质数因子只有2,3,5)
 * 14 => false (质数因子多了7)
 */
public class OJ263 {
    public boolean isUgly_dfs(int num) {
        if (num == 1) {
            return true;
        }
        if (num < 1) {
            return false;
        }
        if (num % 2 == 0) {
            return isUgly_dfs(num / 2);
        }
        if (num % 3 == 0) {
            return isUgly_dfs(num / 3);
        }
        if (num % 5 == 0) {
            return isUgly_dfs(num / 5);
        }
        return false;
    }

    public boolean isUgly(int num) {
        if (num == 1) return true;
        if (num == 0) return false;
        while (num % 2 == 0) num = num >> 1;
        while (num % 3 == 0) num = num / 3;
        while (num % 5 == 0) num = num / 5;
        return num == 1;
    }

    public static void main(String[] args) {
        OJ263 obj = new OJ263();
        System.out.println(obj.isUgly(14));
        System.out.println(obj.isUgly(6));
        System.out.println(obj.isUgly(8));
        System.out.println(obj.isUgly(0));
    }
}
