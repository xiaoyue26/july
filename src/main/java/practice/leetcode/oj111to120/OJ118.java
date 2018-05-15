package practice.leetcode.oj111to120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/20.
 */
public class OJ118 {
    private Integer getI(List<Integer> row, int index) {
        if (index >= 0 && index < row.size()) {
            return row.get(index);
        } else {
            return 0;
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pre = new ArrayList<>(Arrays.asList(1));
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                row.add(getI(pre, j - 1) + getI(pre, j));
            }

            res.add(row);
            pre = row;
        }

        return res;
    }

    public static void main(String[] args) {
        OJ118 obj = new OJ118();
        System.out.println(obj.generate(5));
    }
}
