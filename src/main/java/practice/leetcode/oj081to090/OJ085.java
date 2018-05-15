package practice.leetcode.oj081to090;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/12/8.
 * 一行行处理.DP.
 */
public class OJ085 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int left[] = new int[n], right[] = new int[n], height[] = new int[n];
        Arrays.fill(left, 0);
        Arrays.fill(right, n);
        Arrays.fill(height, 0);
        int max = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // deal height. 截止i行,第j列的高度.(必须含m[i][j])
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            // deal left. 截止i行时,height不低于height[j]的最左.
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // deal right  (从末尾开始处理.) 截止i行时,height不低于height[j]的最右.
            for (int j = n - 1; j >= 0; --j) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = n;
                    cur_right = j;
                }

            }
            // compute max
            for (int j = 0; j < n; j++) {
                max = Math.max(max,
                        height[j] * (right[j] - left[j])
                );
            }


        }


        return max;
    }

    public static void main(String[] args) {
        OJ085 obj = new OJ085();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'}
                , {'1', '0', '1', '1', '1'}
                , {'1', '1', '1', '1', '1'}
                , {'1', '0', '0', '1', '0'}
        };
        System.out.println(obj.maximalRectangle(matrix));
    }
}
