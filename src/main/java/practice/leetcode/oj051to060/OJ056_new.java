package practice.leetcode.oj051to060;

import practice.leetcode.utils.Interval;
import practice.leetcode.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/27.
 */
public class OJ056_new {

    public int[][] merge(int[][] input) {
        if (input.length <= 1) {
            return input;
        }
        List<int[]> tmp = new ArrayList<>();
        Arrays.sort(input, (o1, o2) -> o1[0] - o2[0]);
        int[] pre = input[0];
        tmp.add(pre);
        for (int i = 1; i < input.length; i++) {
            int[] cur = input[i];
            if (cur[0] <= pre[1]) {
                pre[1] = Math.max(pre[1], cur[1]);
                // return input;
            } else {
                pre = cur;
                tmp.add(pre);
            }
        }
        int[][] res = new int[tmp.size()][2];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }


    public static void main(String[] args) {
        OJ056_new obj = new OJ056_new();
        // [[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
        int[][] input = new int[][]{
                {2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}
        };
        PrintUtils.print(obj.merge(input));// [1,3],[4,7]

    }
}
