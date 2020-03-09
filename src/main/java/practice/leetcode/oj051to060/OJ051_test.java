package practice.leetcode.oj051to060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/25.
 */
public class OJ051_test {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 1 || n == 2) {
            return res;
        }


        boolean col[] = new boolean[n];
        boolean leftUp[] = new boolean[2 * n - 1];
        boolean rightUp[] = new boolean[2 * n - 1];
        char[] dotChars = new char[n];
        for (int i = 0; i < n; i++) {
            dotChars[i] = '.';
        }
        dfs(res, 0, n, new ArrayList<>(), col, leftUp, rightUp, dotChars);


        return res;
    }

    private void dfs(List<List<String>> res, int i, int n, List<String> preRes, boolean[] col, boolean[] leftUp, boolean[] rightUp, char[] dotChars) {
        if (i == n) {
            res.add(new ArrayList<>(preRes));
            return;
        }
        for (int j = 0; j < n; j++) {// try col
            if (conflict(i, j, n, col, leftUp, rightUp)) {
                continue;
            }
            col[j] = true;
            dotChars[j] = 'Q';
            preRes.add(String.valueOf(dotChars));
            dotChars[j] = '.';
            leftUp[n - 1 + i - j] = true;
            rightUp[2 * n - 2 - (i + j)] = true;
            dfs(res, i + 1, n, preRes, col, leftUp, rightUp, dotChars);
            col[j] = false;
            preRes.remove(preRes.size() - 1);
            leftUp[n - 1 + i - j] = false;
            rightUp[2 * n - 2 - (i + j)] = false;
        }

    }

    private boolean conflict(int i, int j, int n, boolean[] col, boolean[] leftUp, boolean[] rightUp) {
        if (col[j]
                || leftUp[n - 1 + i - j]
                || rightUp[2 * n - 2 - (i + j)]) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        OJ051_test obj = new OJ051_test();
        System.out.println(obj.solveNQueens(4));
    }
}
