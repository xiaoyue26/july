package practice.leetcode.oj441to450;

/**
 * @author xiaoyue26
 */
public class OJ441 {
    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        double x=n;
        return (int)(Math.sqrt(8 * x + 1) - 1) / 2;
    }

    /*还可以二分搜索 <46341*/
    public static void main(String[] args) {
        OJ441 obj = new OJ441();
        System.out.println(obj.arrangeCoins(1));// 1
        System.out.println(obj.arrangeCoins(5));// 2
        System.out.println(obj.arrangeCoins(8));// 3
        System.out.println(obj.arrangeCoins(1804289383));// 60070
    }
}
