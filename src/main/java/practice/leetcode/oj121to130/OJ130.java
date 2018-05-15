package practice.leetcode.oj121to130;

/**
 * Created by xiaoyue26 on 17/12/25.
 */
public class OJ130 {
    public void solve(char[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] canOut = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, board, canOut);
            dfs(i, n - 1, board, canOut);
        }
        for (int j = 1; j < n - 1; j++) {
            dfs(0, j, board, canOut);
            dfs(m - 1, j, board, canOut);
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!canOut[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board, boolean[][] canOut) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if(canOut[i][j]){
            return;
        }
        if (board[i][j] == 'O') {
            canOut[i][j] = true;
            int leftj = j - 1;
            int rightj = j + 1;
            int upi = i - 1;
            int downi = i + 1;
            dfs(i,leftj,board,canOut);
            dfs(i,rightj,board,canOut);
            dfs(upi,j,board,canOut);
            dfs(downi,j,board,canOut);
        }
    }

    public static void main(String[] args) {
        OJ130 obj = new OJ130();
        char[][] board = new char[][]{
                /*{'x', 'x', 'x', 'x'}
                , {'x', 'o', 'o', 'x'}
                , {'x', 'x', 'o', 'x'}
                , {'x', 'o', 'x', 'x'}
                */
                {'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'}, {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}

        };
        obj.solve(board);
        for (char[] row : board) {
            System.out.println(new String(row));
        }


    }
}
