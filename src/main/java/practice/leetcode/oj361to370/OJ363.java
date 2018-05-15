package practice.leetcode.oj361to370;

import java.util.TreeSet;

/**
 * @author xiaoyue26
 * 找一个和小于等于k的矩形（不能是一条线）
 * 求这个和的最大值。（理想的话，最大就是k了）
 * 2维转化成1维做
 */
public class OJ363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = 0;
        if (m > 0) n = matrix[0].length;
        if (m * n == 0) return 0;

        int M = Math.max(m, n);
        int N = Math.min(m, n);

        int ans = Integer.MIN_VALUE;
        for (int x = 0; x < N; x++) {
            int sums[] = new int[M];
            for (int y = x; y < N; y++) {
                TreeSet<Integer> set = new TreeSet<>();
                int num = 0;
                for (int z = 0; z < M; z++) {
                    sums[z] += m > n ? matrix[z][y] : matrix[y][z];
                    num += sums[z];
                    if (num <= k) ans = Math.max(ans, num);
                    Integer i = set.ceiling(num - k);
                    if (i != null) ans = Math.max(ans, num - i);
                    set.add(num);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        OJ363 obj = new OJ363();
        System.out.println(obj.maxSumSubmatrix(new int[][]{
                        {1, 0, 1}
                        , {0, -2, 3}
                }
                , 2
        ));// 2 // [[0, 1], [-2, 3]]

    }
}
