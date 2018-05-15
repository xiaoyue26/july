package practice.leetcode.oj041to050;

import practice.leetcode.utils.PrintUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xiaoyue26 on 17/11/23.
 */
public class OJ048 {
    private static void swap(Object[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            return;
        }
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }

    private static void reverse(Object[] arr) {
        int size = arr.length;
        for (int i = 0, mid = size >> 1, j = size - 1; i < mid; i++, j--)
            swap(arr, i, j);
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return;
        }
        reverse(matrix);
        //PrintUtils.print(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }

    }

    public static void main(String[] args) {
        OJ048 obj = new OJ048();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        PrintUtils.print(matrix);
        obj.rotate(matrix);
        PrintUtils.print(matrix);
    }
}
