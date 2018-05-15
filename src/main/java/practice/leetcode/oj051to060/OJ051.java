package practice.leetcode.oj051to060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/25.
 */
public class OJ051 {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        dfs(board, res, 0);
        return res;
    }


    private boolean conflit(char[][] board, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (j == y) {
                        return true;
                    }
                    if (i - x == j - y) {
                        return true;
                    }
                    if (i - x == y - j) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private void dfs(char[][] board, List<List<String>> res, int curRow) {

        if (curRow >= board.length) {
            // record board
            List<String> ans = new ArrayList<>(board.length);
            for (char[] row : board) {
                ans.add(String.valueOf(row));
            }
            res.add(ans);
            return;
        }
        for (int j = 0; j < board[0].length; j++) {
            if (!conflit(board, curRow, j)) {
                board[curRow][j] = 'Q';
                dfs(board, res, curRow + 1);
                board[curRow][j] = '.';
            }
        }


    }

    public static void main(String[] args) {
        OJ051 obj = new OJ051();
        System.out.println(obj.solveNQueens(4));
    }
}
