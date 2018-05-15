package practice.leetcode.oj371to380;

/**
 * @author xiaoyue26
 */
public class OJ374 {
    private int guess(int n) {
        if (n < 6) {
            return 1;
        }
        if (n > 6) {
            return -1;
        }
        return 0;
    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        int mid;
        while (left <= right) {
            mid = (left + right) >>> 1;
            if (guess(mid) < 0) {
                right = mid - 1;
            } else if (guess(mid) > 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -(left + 1);
    }

    public static void main(String[] args) {
        OJ374 obj = new OJ374();
        System.out.println(obj.guessNumber(10));// 6
    }
}
