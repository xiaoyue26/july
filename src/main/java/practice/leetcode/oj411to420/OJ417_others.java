package practice.leetcode.oj411to420;

import practice.leetcode.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyue26
 */
public class OJ417_others {
    List<int[]> result = new ArrayList<>();

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        char[][] visited = new char[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            dfs(matrix, 0, i, visited, 'P');
        }

        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, i, 0, visited, 'P');
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dfs(matrix, matrix.length - 1, i, visited, 'A');
        }
        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, i, matrix[0].length - 1, visited, 'A');
        }
        return result;
    }

    public void dfs(int[][] matrix, int i, int j, char[][] visited, char o) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return;
        }

        if (o == 'A' && visited[i][j] == 'P') { /// if both P & A can reach, then add to the result list
            result.add(new int[]{i, j});
        }

        if (visited[i][j] == o) {
            return;
        }

        visited[i][j] = o;

        if (i + 1 < matrix.length && matrix[i][j] <= matrix[i + 1][j]) {
            dfs(matrix, i + 1, j, visited, o);
        }

        if (i - 1 >= 0 && matrix[i][j] <= matrix[i - 1][j]) {
            dfs(matrix, i - 1, j, visited, o);
        }

        if (j + 1 < matrix[0].length && matrix[i][j] <= matrix[i][j + 1]) {
            dfs(matrix, i, j + 1, visited, o);
        }

        if (j - 1 >= 0 && matrix[i][j] <= matrix[i][j - 1]) {
            dfs(matrix, i, j - 1, visited, o);
        }

    }

    public static void main(String[] args) {
        OJ417_others obj = new OJ417_others();
        List<int[]> res = obj.pacificAtlantic(new int[][]{
                {7, 1, 17, 13, 9, 10, 5, 14, 0, 3}
                , {7, 15, 7, 8, 15, 16, 10, 10, 5, 13}
                , {18, 9, 15, 8, 19, 16, 7, 5, 5, 10}
                , {15, 11, 18, 3, 1, 17, 6, 4, 10, 19}
                , {3, 16, 19, 12, 12, 19, 2, 14, 5, 9}
                , {7, 16, 0, 13, 14, 7, 2, 8, 6, 19}
                , {5, 10, 1, 10, 2, 12, 19, 1, 0, 19}
                , {13, 18, 19, 12, 17, 17, 4, 5, 8, 2}
                , {2, 1, 17, 13, 14, 12, 14, 2, 16, 10}
                , {5, 8, 1, 11, 16, 1, 18, 15, 6, 19}
                , {3, 8, 14, 14, 5, 0, 2, 7, 5, 1}
                , {17, 1, 9, 17, 10, 10, 10, 7, 1, 16}//11,3
                , {14, 18, 5, 11, 17, 15, 8, 8, 14, 13}
                , {6, 4, 10, 17, 8, 0, 11, 4, 2, 8}
                , {16, 11, 17, 9, 3, 2, 11, 0, 6, 5}
                , {12, 18, 18, 11, 1, 7, 12, 16, 12, 12}
                , {2, 14, 12, 0, 2, 8, 5, 10, 7, 0}
                , {16, 13, 1, 19, 8, 13, 11, 8, 11, 3}
                , {11, 2, 8, 19, 6, 14, 14, 6, 16, 12}
                , {18, 0, 18, 10, 16, 15, 15, 12, 4, 3}
                , {8, 15, 9, 13, 8, 2, 6, 11, 17, 6}
                , {7, 3, 0, 18, 7, 12, 2, 3, 12, 10}
                , {7, 9, 13, 0, 11, 16, 9, 9, 12, 13}
                , {9, 4, 19, 6, 8, 10, 12, 6, 7, 11}
                , {5, 9, 18, 0, 4, 9, 6, 4, 0, 1}
                , {9, 12, 1, 11, 13, 13, 0, 16, 0, 6}
                , {7, 15, 4, 8, 15, 17, 17, 19, 15, 1}
                , {7, 17, 4, 1, 1, 14, 10, 19, 10, 19}
                , {10, 5, 12, 5, 8, 8, 14, 14, 6, 0}
                , {16, 10, 10, 7, 13, 4, 0, 15, 18, 0}
                , {11, 2, 10, 6, 5, 13, 4, 5, 3, 1}
                , {9, 14, 16, 14, 15, 3, 2, 13, 17, 8}
                , {19, 2, 10, 1, 2, 15, 12, 10, 2, 5}
                , {12, 4, 8, 9, 8, 6, 4, 14, 14, 0}
                , {11, 17, 17, 4, 16, 13, 6, 15, 5, 7}
                , {12, 18, 1, 3, 9, 10, 7, 1, 1, 1}
                , {18, 6, 10, 8, 12, 14, 9, 12, 10, 3}
                , {15, 13, 18, 13, 8, 5, 12, 14, 18, 0}
                , {15, 4, 8, 9, 19, 18, 6, 19, 12, 0}
                , {4, 14, 15, 4, 17, 17, 9, 17, 9, 0}
                , {6, 17, 16, 10, 3, 8, 8, 18, 15, 9}
                , {3, 8, 4, 2, 13, 0, 2, 8, 8, 2}
                , {14, 12, 13, 12, 17, 4, 16, 9, 8, 7}
                , {0, 19, 8, 16, 1, 13, 7, 6, 15, 11}
                , {1, 13, 16, 14, 10, 4, 11, 19, 9, 13}
                , {8, 0, 2, 1, 16, 12, 16, 9, 9, 9}
                , {5, 2, 10, 4, 8, 12, 17, 0, 2, 15}
                , {11, 2, 15, 15, 14, 9, 11, 19, 18, 11}
                , {4, 4, 1, 5, 13, 19, 9, 17, 17, 17}
                , {4, 1, 8, 0, 8, 19, 11, 0, 5, 4}
                , {8, 16, 14, 18, 12, 2, 0, 19, 0, 13}
                , {7, 11, 3, 18, 8, 2, 2, 19, 8, 7}
                , {3, 13, 6, 1, 12, 16, 4, 13, 0, 5}
                , {12, 1, 16, 19, 2, 12, 16, 15, 19, 6}
                , {1, 7, 12, 15, 3, 3, 13, 17, 16, 12}
        });
        for (int[] r : res) {
            PrintUtils.print(r);
        }
    }
}
