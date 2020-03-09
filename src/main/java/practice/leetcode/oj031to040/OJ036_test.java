package practice.leetcode.oj031to040;

import java.util.Arrays;

/**
 * Created by xiaoyue26 on 17/11/18.
 */
public class OJ036_test {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        int len = 9;
        boolean row[][] = new boolean[len][len];
        boolean col[][] = new boolean[len][len];
        boolean block[][] = new boolean[len][len];
        int c;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                c = board[i][j] - '1';
                if (row[i][c]) return false;
                if (col[j][c]) return false;
                boolean[] cb = block[i / 3 * 3 + j / 3];
                if (cb[c]) return false;
                row[i][c] = true;
                col[j][c] = true;
                cb[c] = true;
            }
        }


        return true;
    }


    public static void main(String[] args) {
        OJ036_test obj = new OJ036_test();
        char[][] board = {
                {'5', '3', '.', '.', '7'},
                {'6', '.', '.', '1', '9'}
        };
        System.out.println(obj.isValidSudoku(board));
    }
}
