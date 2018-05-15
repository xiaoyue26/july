package practice.leetcode.oj231to240;

/**
 * Created by xiaoyue26 on 18/2/6.
 */
public class OJ240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length) {
            if (target < matrix[i][j]) {
                --j;
            } else if (target > matrix[i][j]) {
                ++i;
            } else {
                return true;
            }

        }

        return false;

    }

    public static void main(String[] args) {
        OJ240 obj = new OJ240();
        System.out.println(obj.searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 5));
    }
}
