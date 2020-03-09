package practice.leetcode.oj071to080;

/**
 * Created by xiaoyue26 on 17/12/3.
 */
public class OJ074_test {

    @FunctionalInterface
    public interface GetIdataFunction {
        int getI(int i);

        default String getInfo() {
            return "找第i个数据";
        }

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0]) {
            return false;
        }

        int lowerBound = getLowerBound(target, 0, matrix.length - 1, new GetIdataFunction() {
            @Override
            public int getI(int i) {
                return matrix[i][0];
            }
        });
        if (lowerBound >= 0) {
            return true;
        }
        final int finalLowerBound = -lowerBound - 2;
        int x = getLowerBound(target, 0, matrix[0].length - 1, new GetIdataFunction() {
            @Override
            public int getI(int i) {
                return matrix[finalLowerBound][i];
            }
        });
        return x >= 0;
    }

    private int getLowerBound(int target, int left, int right, GetIdataFunction helper) {
        int mid;
        while (left <= right) {
            mid = (left + right) >>> 1;
            int midVal = helper.getI(mid);
            if (target < midVal) {
                right = mid - 1;
            } else if (target > midVal) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -left - 1;
    }


    public static void main(String[] args) {
        OJ074_test obj = new OJ074_test();
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
