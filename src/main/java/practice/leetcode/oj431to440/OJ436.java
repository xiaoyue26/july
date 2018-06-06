package practice.leetcode.oj431to440;

import practice.leetcode.utils.Interval;
import practice.leetcode.utils.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoyue26
 */
public class OJ436 {
    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> start2index = new HashMap<>();
        Interval[] back = new Interval[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            back[i] = intervals[i];
            start2index.put(intervals[i].start, i);
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length - 1; i++) {
            int afterIndex = i;
            int beforeIndex = start2index.get(intervals[afterIndex].start);
            res[beforeIndex] = -1;
            for (int j = afterIndex + 1; j < intervals.length; j++) {
                if (intervals[afterIndex].end <= intervals[j].start) {
                    res[beforeIndex] = start2index.get(intervals[j].start);
                    break;
                }
            }

        }
        int afterIndex = intervals.length - 1;
        int beforeIndex = start2index.get(intervals[afterIndex].start);
        res[beforeIndex] = -1;


        return res;
    }

    public static void main(String[] args) {
        OJ436 obj = new OJ436();
        PrintUtils.print(obj.findRightInterval(new Interval[]{
                new Interval(1, 4)
                , new Interval(2, 3)
                , new Interval(3, 4)
        }));//-1,2,-1
        PrintUtils.print(obj.findRightInterval(new Interval[]{
                new Interval(3, 4)
                , new Interval(2, 3)
                , new Interval(1, 2)
        }));// -1,0,1
        PrintUtils.print(obj.findRightInterval(new Interval[]{
                new Interval(1, 2)
        }));// -1
        // [[1,12],[2,9],[3,10],[13,14],[15,16],[16,17]]
        PrintUtils.print(obj.findRightInterval(new Interval[]{
                new Interval(1, 12)
                , new Interval(2, 9)
                , new Interval(3, 10)
                , new Interval(13, 14)
                , new Interval(15, 16)
                , new Interval(16, 17)
        }));// [3,3,3,4,5,-1]
    }
}
