package practice.leetcode.oj071to080;

/**
 * Created by xiaoyue26 on 17/12/5.
 */
public class OJ079 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        boolean curRes;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                curRes = dfs(board, i, j, word);
                if (curRes) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length) {
            return false;
        }

        if (board[i][j] != word.charAt(0)) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = 0;//mark as invalid char
        boolean curRes = dfs(board, i + 1, j, word.substring(1))
                ||dfs(board, i - 1, j, word.substring(1))
                || dfs(board, i, j + 1, word.substring(1))
                || dfs(board, i, j - 1, word.substring(1));
        board[i][j] = tmp;
        return curRes;
    }

    public static void main(String[] args) {
        OJ079 obj = new OJ079();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(obj.exist(board, "ABCCED"));//true
        System.out.println(obj.exist(board, "SEE"));//true
        System.out.println(obj.exist(board, "ABCB"));//false
    }
}
