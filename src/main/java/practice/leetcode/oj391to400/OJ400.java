package practice.leetcode.oj391to400;

/**
 * @author xiaoyue26
 */
public class OJ400 {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }

    public static void main(String[] args) {
        OJ400 obj = new OJ400();
        System.out.println(obj.findNthDigit(3)); // 3
        System.out.println(obj.findNthDigit(11)); // 0
        System.out.println(obj.findNthDigit(2147483647)); // 2
        System.out.println(obj.findNthDigit(10)); // 1
        System.out.println(obj.findNthDigit(12)); // 1

    }
}
