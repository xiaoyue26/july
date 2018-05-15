package practice.leetcode.oj281to290;

import practice.leetcode.utils.PrintUtils;

/**
 * Created by jiuzhoumu on 2018/2/17.
 * 1 2,3个邻居1，则1
 * 0 3个邻居1，则1
 * 其余0.
 * 1->0 -1  |x|=1
 * 0->1 -2  -2,0=>0 即： |x+1|=1
 */
public class OJ289_old {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int neibor1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                neibor1 = count(board, i, j);
                if (neibor1 == 3) {
                    if (board[i][j] == 0) {
                        board[i][j] = -2;
                    }
                } else if (neibor1 == 2 && board[i][j] == 1) {

                } else {
                    board[i][j] = -board[i][j];
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == -2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int count(int[][] board, int i, int j) {
        int count = 0;
        if (i - 1 >= 0) {
            // 1. i-1,j
            if (board[i - 1][j] == 1 || board[i - 1][j] == -1) {
                count++;
            }
            if (j - 1 >= 0) {
                // 2. i-1,j-1
                if (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -1) {
                    count++;
                }
            }
            if (j + 1 < board[0].length) {
                // 3. i-1,j+1
                if (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -1) {
                    count++;
                }
            }
        }
        if (i + 1 < board.length) {
            // 4. i+1,j
            if (board[i + 1][j] == 1 || board[i + 1][j] == -1) {
                count++;
            }
            if (j - 1 >= 0) {
                // 5. i+1,j-1
                if (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -1) {
                    count++;
                }
            }
            if (j + 1 < board[0].length) {
                // 6. i+1,j+1
                if (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -1) {
                    count++;
                }
            }
        }
        if (j - 1 >= 0) {
            // 7. i,j-1
            if (board[i][j - 1] == 1 || board[i][j - 1] == -1) {
                count++;
            }
        }
        if (j + 1 < board[0].length) {
            // 8. i,j+1
            if (board[i][j + 1] == 1 || board[i][j + 1] == -1) {
                count++;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        OJ289_old obj = new OJ289_old();
        int[][] board = new int[][]{
                {1, 0, 1}
                , {1, 1, 1}
                , {1, 1, 1}
        };
        obj.gameOfLife(board);
        PrintUtils.print(board);
    }
}
