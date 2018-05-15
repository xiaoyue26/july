package practice.leetcode.oj031to040;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/11/18.
 */
public class OJ036 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        boolean[] row = new boolean[9];
        boolean[] col = new boolean[9];

        for (int i = 0; i < 9; i++) {
            Arrays.fill(col, false);
            Arrays.fill(row, false);
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (row[c - '1']) {
                        return false;
                    }
                    row[c - '1'] = true;
                }
                char d = board[j][i];
                if (d != '.') {
                    if (col[d - '1']) {
                        return false;
                    }
                    col[d - '1'] = true;
                }
            }
        }
        // check 3x3

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                Arrays.fill(row, false);
                for (int k = 0; k < 3; ++k) {
                    for (int l = 0; l < 3; l++) {
                        char c = board[i * 3 + k][j * 3 + l];
                        if (c != '.') {
                            if (row[c - '1']) {
                                return false;
                            }
                            row[c - '1'] = true;
                        }
                    }
                }
            }
        }


        return true;
    }

    public boolean isValidSudoku_quick(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        boolean[] row = new boolean[9];
        boolean[] col = new boolean[9];
        boolean[] block = new boolean[9];
        char c1, c2, c3;
        for (int i = 0; i < 9; i++) {
            Arrays.fill(col, false);
            Arrays.fill(row, false);
            Arrays.fill(block, false);
            for (int j = 0; j < 9; j++) {
                // row
                c1 = board[i][j];
                if (c1 != '.') {
                    if (row[c1 - '1']) {
                        return false;
                    }
                    row[c1 - '1'] = true;
                }
                // col
                c2 = board[j][i];
                if (c2 != '.') {
                    if (col[c2 - '1']) {
                        return false;
                    }
                    col[c2 - '1'] = true;
                }
                // block
                if (i < 3) {
                    c3 = board[j / 3 + i * 3][j % 3];
                } else if (i < 6) {
                    c3 = board[j / 3 + (i - 3) * 3][j % 3 + 3];
                } else { // i<9
                    c3 = board[j / 3 + (i - 6) * 3][j % 3 + 6];
                }
                if (c3 != '.') {
                    if (block[c3 - '1']) {
                        return false;
                    }
                    block[c3 - '1'] = true;
                }
            }
        }
        // check 3x3


        return true;
    }

    public boolean isValidSudoku_mostfast(char[][] board) { // 空间O(n2)
        if (board == null || board[0] == null)
            return false;
        int row = board.length, column = board[0].length;
        int cur;
        boolean rowflag[][] = new boolean[9][], colflag[][] = new boolean[9][];
        boolean blockflag[][] = new boolean[9][];
        for (int i = 0; i < rowflag.length; i++) {
            rowflag[i] = new boolean[9];
            blockflag[i] = new boolean[9];
            colflag[i] = new boolean[9];
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == '.')
                    continue;
                cur = (int) (board[i][j] - '1');
                if (cur < 0 || cur > 9)
                    continue;
                if (colflag[i][cur])
                    return false;
                else
                    colflag[i][cur] = true;
                // check row:
                if (rowflag[j][cur])
                    return false;
                else
                    rowflag[j][cur] = true;
                // check block:
                if (blockflag[(int) (i / 3) * 3 + j / 3][cur])
                    return false;
                else
                    blockflag[(int) (i / 3) * 3 + j / 3][cur] = true;
            }
        }
        return true;
    }

    private boolean fill(boolean[][] flags, int i, char c) {
        if (c != '.') {
            if (flags[i][c - '1']) {
                return false;
                //System.out.println("failed");
            } else {
                flags[i][c - '1'] = true;
            }
        }
        return true;
    }
    public boolean isValidSudoku_clean(char[][] board) { // 空间O(n2)
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        boolean row[][] = new boolean[9][9];
        boolean col[][] = new boolean[9][9];
        boolean block[][] = new boolean[9][9];


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if(!fill(row, i, c))return false;
                if(!fill(col, j, c))return false;
                if(!fill(block, i / 3 * 3 + j / 3, c))return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        OJ036 obj = new OJ036();
        char[][] board = {
                {'5', '3', '.', '.', '7'},
                {'6', '.', '.', '1', '9'}
        };
        System.out.println(obj.isValidSudoku(board));
    }
}
