package practice.leetcode.oj121to130;

/**
 * Created by xiaoyue26 on 17/12/25.
 * 尝试用螺旋矩阵解, 结果发现不可行, 还是改用dfs.
 */
public class OJ130_old {

    private void getNextPos(int[] pos, int[] direct, int[] bound) {
        int x = pos[0] + direct[0];
        int y = pos[1] + direct[1];
        if (x < bound[0]) {
            bound[2]++;
            direct[0] = 0;
            direct[1] = 1;
        } else if (x > bound[1]) {
            bound[3]--;
            direct[0] = 0;
            direct[1] = -1;
        } else if (y < bound[2]) {
            bound[1]--;
            direct[0] = -1;
            direct[1] = 0;
        } else if (y > bound[3]) {
            bound[0]++;
            direct[0] = 1;
            direct[1] = 0;
        }
        pos[0] += direct[0];
        pos[1] += direct[1];
    }

    public void solve(char[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] canOut = new boolean[m][n];
        int direct[] = new int[]{0, 1};
        int pos[] = new int[]{0, -1};
        int bound[] = new int[]{0, m - 1, 0, n - 1};// 上下左右
        int x, y;
        int count = m * n;
        while (count > 0) {
            // go next pos
            getNextPos(pos, direct, bound);
            x = pos[0];
            y = pos[1];
            if (board[x][y] == 'x' || board[x][y] == 'X') {
                canOut[x][y] = false;
            } else {
                if (canOut[x][y]||checkAround(x, y, m, n, canOut)) {
                    canOut[x][y] = true;
                }
                else{
                    board[x][y]='X';
                }
            }
            count--;
        }
        System.out.println();

    }

    private boolean checkAround(int x, int y, int m, int n, boolean[][] canOut) {
        int leftj = y - 1;
        int rightj = y + 1;
        int upi = x - 1;
        int downi = x + 1;
        return checkPos(x, leftj, m, n, canOut)
                || checkPos(x, rightj, m, n, canOut)
                || checkPos(upi, y, m, n, canOut)
                || checkPos(downi, y, m, n, canOut);
    }

    private boolean checkPos(int i, int j, int m, int n, boolean[][] canOut) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return true;
        }

        return canOut[i][j];
    }

    public static void main(String[] args) {
        OJ130_old obj = new OJ130_old();
        char[][] board = new char[][]{
                /*{'x', 'x', 'x', 'x'}
                , {'x', 'o', 'o', 'x'}
                , {'x', 'x', 'o', 'x'}
                , {'x', 'o', 'x', 'x'}
                */
                {'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}

        };
        obj.solve(board);
        for (char[] row : board) {
            System.out.println(new String(row));
        }

    }
}
