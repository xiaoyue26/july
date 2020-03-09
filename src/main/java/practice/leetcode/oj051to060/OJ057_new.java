package practice.leetcode.oj051to060;

import practice.leetcode.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/28.
 */
public class OJ057_new {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int index = 0;
        int start = newInterval[0];
        int end = newInterval[1];

        // add before:
        while (index < intervals.length && intervals[index][1] < start) {
            result.add(intervals[index]);
            index++;
        }

        // merge:
        while (index < intervals.length && intervals[index][0] <= end) {
            start = Math.min(intervals[index][0], start);
            end = Math.max(intervals[index][1], end);
            index++;
        }
        // Add merged interval:
        result.add(new int[]{start, end});

        // Add the remaining intervals
        while (index < intervals.length) {
            result.add(intervals[index]);
            index++;
        }
        // Populate the result array
        int[][] res = new int[result.size()][2];
        int i = 0;
        for (int[] inter : result) {
            res[i++] = inter;
        }
        return res;
    }

    public static void main(String[] args) {
        OJ057_new obj = new OJ057_new();
        // Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
        // Output: [[1,5],[6,9]]
        PrintUtils.print(obj.insert(new int[][]{
                {1, 3}, {6, 9}
        }, new int[]{2, 5}));
        // Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        // Output: [[1,2],[3,10],[12,16]]
        PrintUtils.print(obj.insert(new int[][]{
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        }, new int[]{4, 8}));
        PrintUtils.print(obj.insert(new int[][]{
                {1, 5}
        }, new int[]{6, 8}));

    }
}
