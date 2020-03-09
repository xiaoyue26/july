package practice.leetcode.oj051to060;

import com.google.inject.internal.cglib.reflect.$FastClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/26.
 */
public class OJ054_test {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int[] direct = new int[]{0, 1};
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        int i = 0, j = 0;
        for (int k = 0; k < n * m; k++) {
            visited[i][j] = true;
            res.add(matrix[i][j]);
            int maxTry = 4;
            while (!next_pos_valid(i, j, n, m, direct, visited) && maxTry > 0) {
                turn(direct);
                maxTry--;
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

        } else if (direct[1] == 0) {
            direct[1] = -direct[0];
            direct[0] = 0;
        }


    }

    private boolean next_pos_valid(int i, int j, int n, int m, int[] direct, boolean[][] visited) {
        i = i + direct[0];
        j = j + direct[1];

        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        OJ054_test obj = new OJ054_test();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(obj.spiralOrder(matrix));
    }
}
