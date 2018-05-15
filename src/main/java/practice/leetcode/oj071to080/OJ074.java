package practice.leetcode.oj071to080;

/**
 * Created by xiaoyue26 on 17/12/3.
 */
public class OJ074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // search row
        int left = 0, right = matrix.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (target < matrix[mid][0]) {
                right = mid - 1;
            } else if (target > matrix[mid][0]) {
                left = mid + 1;
            } else {// ==
                return true;
            }
        }
        if (left <= 0) {
            return false;
        }
        // search col
        int row = left - 1;
        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (target < matrix[row][mid]) {
                right = mid - 1;
            } else if (target > matrix[row][mid]) {
                left = mid + 1;
            } else {// ==
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OJ074 obj = new OJ074();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(obj.searchMatrix(matrix, matrix[i][j]));
            }
        }


    }
}
