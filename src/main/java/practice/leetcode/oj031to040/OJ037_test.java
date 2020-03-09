package practice.leetcode.oj031to040;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/18.
 */
public class OJ037_test {


    public void solveSudoku(char[][] board) {
        int len = 9;
        if (board == null || board.length != len || board[0].length != len) {
            return;
        }
        boolean rows[][] = new boolean[len][len];
        boolean cols[][] = new boolean[len][len];
        boolean blocks[][] = new boolean[len][len];
        int c;
        List<int[]> todoList = new ArrayList<>();
        // 1. fill status:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    todoList.add(new int[]{i, j});
                    continue;
                }
                c = board[i][j] - '1';
                if (rows[i][c]) return;
                if (cols[j][c]) return;
                if (blocks[i / 3 * 3 + j / 3][c]) return;
                rows[i][c] = true;
                cols[j][c] = true;
                blocks[i / 3 * 3 + j / 3][c] = true;
            }
        }
        // 2. dfs:
        dfs(board, rows, cols, blocks, todoList, 0);
    }

    private boolean dfs(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] blocks, List<int[]> todoList, int index) {
        if (todoList.size() == index) {
            return true;
        }
        int[] xy = todoList.get(index);
        int i = xy[0];
        int j = xy[1];
        for (int c = 0; c < 9; c++) {
            if (rows[i][c] || cols[j][c] || blocks[i / 3 * 3 + j / 3][c]) continue;
            rows[i][c] = true;
            cols[j][c] = true;
            blocks[i / 3 * 3 + j / 3][c] = true;
            board[i][j] = (char) (c + '1');
            if(dfs(board, rows, cols, blocks, todoList, index + 1)){
                return true;
            }
            rows[i][c] = false;
            cols[j][c] = false;
            blocks[i / 3 * 3 + j / 3][c] = false;
            // board[i][j] = '.';
        }
        return false;

    }


    public static void main(String[] args) {
        OJ037_test obj = new OJ037_test();
        char[][] board = {
                {'5', '3', '.', '.', '7'},
                {'6', '.', '.', '1', '9'}
        };
        obj.solveSudoku(board);
        System.out.println("there");
    }
}
