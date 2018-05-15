package practice.leetcode.oj371to380;

import java.util.Arrays;

/**
 * @author xiaoyue26
 * 行内递增;列内也递增
 * 但第二行不一定全比第一行大。
 * 思路:
 * 先找到数组的最大值和最小值，然后以此作为二叉搜索的左右两边，求出其中间值，然后看比该值小的有多少个，是否满足条件。
 * 由于假设第k小一定能找到,所以这个方法可行.(收缩范围一定能收敛到目标值)
 */
public class OJ378 {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0], right = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while (left < right) {
            int mid = left + (right - left) / 2;// mid为我们猜测的答案
            int count = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                // System.out.println("row: " + i);
                // System.out.println("mid: " + mid);
                // while (j >= 0 && matrix[i][j] > mid) j--; // 解法1，记忆上次停止的地方
                j = Arrays.binarySearch(matrix[i], mid); // 解法2，直接二分
                if (j < 0) {
                    j = -(j + 1);
                    count += j;
                } else {
                    count += (j + 1);
                }
                //System.out.println("j: " + j);
                // count += (j + 1);
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;// 答案应该用下界， 因为猜想的解不一定在数组中，不断的收缩直到找到在数组中的元素为止

    }

    public int kthSmallest_old(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        OJ378 obj = new OJ378();
        System.out.println(obj.kthSmallest(new int[][]{
                {1, 5, 9}
                , {10, 11, 13}
                , {12, 13, 15}
        }, 8));// 13
        System.out.println(obj.kthSmallest(new int[][]{
                {1, 2}
                , {1, 3}
        }, 2));// 1
        System.out.println(obj.kthSmallest(new int[][]{
                {1, 2}
                , {3, 3}
        }, 4));// 3
    }
}
