package practice.leetcode.oj231to240;

import practice.leetcode.utils.PrintUtils;

/**
 * Created by xiaoyue26 on 18/2/6.
 */
public class OJ239_poor {
    public static int[] maxSlidingWindow(final int[] num, final int k) {
        if (num == null || num.length == 0) return num;
        final int[] max_left = new int[num.length];
        final int[] max_right = new int[num.length];

        max_left[0] = num[0];
        max_right[num.length - 1] = num[num.length - 1];

        for (int i = 1; i < num.length; i++) {
            max_left[i] = (i % k == 0) ? num[i] : Math.max(max_left[i - 1], num[i]);

            final int j = num.length - i - 1;
            max_right[j] = (j % k == 0) ? num[j] : Math.max(max_right[j + 1], num[j]);
        }

        final int[] sliding_max = new int[num.length - k + 1];
        for (int i = 0, j = 0; i + k <= num.length; i++) {
            sliding_max[j++] = Math.max(max_right[i], max_left[i + k - 1]);
        }

        return sliding_max;
    }

    public static void main(String[] args) {
        OJ239_poor obj = new OJ239_poor();
        PrintUtils.print(obj.maxSlidingWindow(new int[]{
                        1, 3, -1, -3, 5, 3, 6, 7
                }
                , 3));
    }
}
