package practice.leetcode.oj051to060;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/26.
 */
public class OJ054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int[] direct = new int[2];
        direct[0] = 0;
        direct[1] = 1;
        int count = matrix.length * matrix[0].length;

        int i = 0, j = 0;
        int left = 0, right = matrix[0].length - 1;
        int up = 0, down = matrix.length - 1;

        while (count > 0) {
            res.add(matrix[i][j]);
            count -= 1;
            if (i + direct[0] > down) {
                right--;
                turn(direct);
            } else if (i + direct[0] < up) {
                left++;
                turn(direct);
            } else if (j + direct[1] > right) {
                up++;
                turn(direct);
            } else if (j + direct[1] < left) {
                down--;
                turn(direct);
            }
            i = i + direct[0];
            j = j + direct[1];


        }

        return res;
    }


    private void turn(int[] direct) {
        if (direct[0] == 0) {
            direct[0] = direct[1];
            direct[1] = 0;
        } else {// dirct[0]!=0
            direct[1] = -direct[0];
            direct[0] = 0;
        }
    }

    public static void main(String[] args) {
        OJ054 obj = new OJ054();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(obj.spiralOrder(matrix));
    }
}
