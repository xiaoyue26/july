package practice.leetcode.oj031to040;

/**
 * Created by xiaoyue26 on 17/11/18.
 */
public class OJ037 {


    public void solveSudoku(char[][] board) {

        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        boolean row[][] = new boolean[9][9];
        boolean col[][] = new boolean[9][9];
        boolean block[][] = new boolean[9][9];


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                fill(row, i, c);
                fill(col, j, c);
                fill(block, i / 3 * 3 + j / 3, c);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    fillBoard(board, row, col, block, i * 9 + j);
                }

            }
        }


    }

    private boolean fillBoard(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int n) {

        if (n >= 81) {
            return true;
        }
        int i = n / 9, j = n % 9;
        if (board[i][j] != '.') {
            return fillBoard(board, row, col, block, n + 1);
        }
        for (int k = 0; k < 9; ++k) {
            if (row[i][k] || col[j][k] || block[i / 3 * 3 + j / 3][k]) {
                continue;
            } else {
                row[i][k] = true;
                col[j][k] = true;
                block[i / 3 * 3 + j / 3][k] = true;
                board[i][j] = (char) (k + '1');
                boolean flag = fillBoard(board, row, col, block, n + 1);
                if (flag) {
                    return true;
                } else {//rollback
                    row[i][k] = false;
                    col[j][k] = false;
                    block[i / 3 * 3 + j / 3][k] = false;
                    board[i][j] = '.';
                }
            }
        }

        return false;
    }


    private boolean fill(boolean[][] flags, int i, char c) {
        if (c != '.') {
            if (flags[i][c - '1']) {
                return false;
            } else {
                flags[i][c - '1'] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OJ037 obj = new OJ037();
        char[][] board = {
                {'5', '3', '.', '.', '7'},
                {'6', '.', '.', '1', '9'}
        };
        obj.solveSudoku(board);
        System.out.println("there");
    }
}
