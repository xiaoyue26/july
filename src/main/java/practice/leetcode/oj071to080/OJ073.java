package practice.leetcode.oj071to080;

import practice.leetcode.utils.PrintUtils;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/12/3.
 */
public class OJ073 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int posi = -1;
        int posj = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (posi == -1) {
                        posi = i;
                        posj = j;
                    } else {
                        matrix[posi][j] = 0;
                        matrix[i][posj] = 0;
                    }
                }
            }
        }
        if (posi == -1) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == posi || j == posj) {
                    continue;
                }
                if (matrix[posi][j] == 0 || matrix[i][posj] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][posj] = 0;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[posi][j] = 0;
        }


    }

    public static void main(String[] args) {
        OJ073 obj = new OJ073();
        int[][] matrix = {
                {1, 0, 1}
                , {1, 1, 1}
                , {1, 1, 1}
        };
        obj.setZeroes(matrix);
        PrintUtils.print(matrix);
    }
}
