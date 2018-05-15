package practice.leetcode.oj071to080;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/4.
 */
public class OJ077 {
    public List<List<Integer>> combine_dfs(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n || n < 1 || k < 1) {
            return res;
        }

        List<List<Boolean>> helper = dfs(n, k);
        for (List<Boolean> row : helper) {
            List<Integer> newRow = new ArrayList<>(k);
            for (int i = 0; i < row.size(); i++) {
                if (row.get(i)) {
                    newRow.add(i + 1);
                }
            }
            res.add(newRow);
        }
        return res;
    }

    private List<List<Boolean>> dfs(int n, int k) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        if (k == 0) {
            List<List<Boolean>> helper = new ArrayList<>(1);
            List<Boolean> row = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                row.add(false);
            }
            helper.add(row);
            return helper;
        }
        if (n == k) {
            List<List<Boolean>> helper = new ArrayList<>(1);
            List<Boolean> row = new ArrayList<>(k);
            for (int i = 0; i < k; i++) {
                row.add(true);
            }
            helper.add(row);
            return helper;
        }

        List<List<Boolean>> row0 = dfs(n - 1, k);
        List<List<Boolean>> row1 = dfs(n - 1, k - 1);
        List<List<Boolean>> helper = new ArrayList<>(row0.size() + row1.size());
        for (List<Boolean> row : row0) {
            row.add(0, false);
            helper.add(row);
        }
        for (List<Boolean> row : row1) {
            row.add(0, true);
            helper.add(row);
        }

        return helper;
    }

    public static void main(String[] args) {
        OJ077 obj = new OJ077();
        System.out.println(obj.combine(4, 2));
    }

    //回溯dfs
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmpRow = new ArrayList<>(k);
        dfs_baktrace(1, n, k, tmpRow, res);
        return res;
    }

    private void dfs_baktrace(int start, int n, int k
            , List<Integer> tmpRow, List<List<Integer>> res) {
        if (k == 0) {// tmpRow.size()==k
            res.add(new ArrayList<>(tmpRow));
            return;
        }

        for (int i = start; i <= n; i++) {
            tmpRow.add(i);
            dfs_baktrace(i + 1, n, k - 1, tmpRow, res);
            tmpRow.remove(tmpRow.size() - 1);
        }
    }


}
