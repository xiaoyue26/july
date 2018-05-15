package practice.leetcode.oj231to240;

/**
 * Created by xiaoyue26 on 18/2/3.
 * 范围内十进制含1的uv.
 */
public class OJ233 {
    public int countDigitOne(int n) {
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            count += (n / divider) * i
                    + Math.min(Math.max(n % divider - i + 1, 0L), i);
        }
        return count;
    }

    public static void main(String[] args) {
        OJ233 obj = new OJ233();
        System.out.println(obj.countDigitOne(13));//返回6. 因为0-13的正数里,包含1的有6个:1, 10, 11, 12, 13
    }
}
