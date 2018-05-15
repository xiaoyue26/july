package practice.leetcode.oj371to380;

/**
 * @author xiaoyue26
 * 手动实现一下二进制加法
 */
public class OJ371 {
    public int getSum(int a, int b) {
        int same = a & b, sum = a ^ b;
        while (same != 0) {
            a = sum;
            b = same << 1;
            same = a & b;
            sum = a ^ b;
        }
        return sum;
    }

    public static void main(String[] args) {
        OJ371 obj = new OJ371();
        System.out.println(obj.getSum(1, 3));
    }
}
