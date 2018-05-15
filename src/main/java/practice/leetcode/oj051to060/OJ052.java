package practice.leetcode.oj051to060;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/25.
 */
public class OJ052 {

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }

        boolean cols[] = new boolean[n];
        boolean side1[] = new boolean[2 * n - 1];
        boolean side2[] = new boolean[2 * n - 1];
        char[][] board = new char[n][n];// all (char)0
        List<Integer> res = Arrays.asList(0);
        return dfs(board, cols, side1, side2, 0, res);

    }

    private int dfs(char[][] board, boolean[] cols, boolean[] side1, boolean[] side2, int curRow, List<Integer> res) {
        if (curRow >= board.length) {
            res.set(0, res.get(0) + 1);
            return res.get(0);
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[curRow][j] != 'Q') {
                if (cols[j] || side1[curRow + j] || side2[curRow - j + board.length - 1]) {
                    continue;
                } else {
                    board[curRow][j] = 'Q';
                    cols[j] = true;
                    side1[curRow + j] = true;
                    side2[curRow - j + board.length - 1] = true;
                    dfs(board, cols, side1, side2, curRow + 1, res);
                    board[curRow][j] = (char) 0;
                    cols[j] = false;
                    side1[curRow + j] = false;
                    side2[curRow - j + board.length - 1] = false;
                }
            }
        }
        return res.get(0);
    }

    public static void main(String[] args) {
        OJ052 obj = new OJ052();
        System.out.println(obj.totalNQueens(4));
    }
}
