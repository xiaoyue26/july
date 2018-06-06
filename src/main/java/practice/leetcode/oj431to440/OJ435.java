package practice.leetcode.oj431to440;

import practice.leetcode.utils.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xiaoyue26
 */
public class OJ435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        int sp = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (sp == 0 || intervals[i].start >= intervals[sp - 1].end) intervals[sp++] = intervals[i];
            else {
                if (intervals[i].end < intervals[sp - 1].end) intervals[sp - 1] = intervals[i];
            }
        }
        return intervals.length - sp;
    }


    public static void main(String[] args) {
        OJ435 obj = new OJ435();
        System.out.println(obj.eraseOverlapIntervals(new Interval[]{
                new Interval(1, 2)
                , new Interval(2, 3)
                , new Interval(3, 4)
                , new Interval(1, 3)
        }));
        System.out.println(obj.eraseOverlapIntervals(new Interval[]{
                new Interval(1, 2)
                , new Interval(1, 2)
                , new Interval(1, 2)
        }));
        System.out.println(obj.eraseOverlapIntervals(new Interval[]{
                new Interval(1, 2)
                , new Interval(2, 3)
        }));
    }
}
