package practice.leetcode.oj261to270;

/**
 * Created by xiaoyue26 on 18/2/9.
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12
 */
public class OJ264 {
    public int nthUglyNumber(int n) {

        if (n <= 0 || n == 1) {
            return n;
        }

        int pointer2 = 0;
        int pointer3 = 0;
        int pointer5 = 0;

        int[] result = new int[n];
        result[0] = 1;

        int i = 1, min = 0;
        while (i < n) {
            min = Math.min(result[pointer2] * 2, Math.min(result[pointer3] * 3, result[pointer5] * 5));

            if (min == result[pointer2] * 2) {
                pointer2++;
            }// 不能用else. 如果是共同因子,需要两个指针或者三个指针都移动.
            if (min == result[pointer3] * 3) {
                pointer3++;
            }
            if (min == result[pointer5] * 5) {
                pointer5++; // 三个指针每次都只加1,保证每个历史数据都用上,而且是从小到大.
            }
            result[i] = min;

            i++;

        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        OJ264 obj = new OJ264();
        System.out.println(obj.nthUglyNumber(2));//2
        System.out.println(obj.nthUglyNumber(7));//8
    }
}
