package practice.leetcode.oj411to420;

/**
 * @author xiaoyue26
 */
public class OJ419 {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    if (preX(board, i - 1, j)) {
                        count--;
                    }
                    if (preX(board, i, j - 1)) {
                        count--;
                    }
                    count++;
                }
            }
        }

        return count;

    }

    private boolean preX(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == 'X') {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        OJ419 obj = new OJ419();
        System.out.println(obj.countBattleships(new char[][]{
                {'X', '.', '.', 'X'}
                , {'.', '.', '.', 'X'}
                , {'.', '.', '.', 'X'}
        }));
    }
}
