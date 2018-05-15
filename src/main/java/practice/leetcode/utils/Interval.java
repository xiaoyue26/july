package practice.leetcode.utils;

import java.util.Comparator;

/**
 * Created by xiaoyue26 on 17/11/27.
 */

public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return String.format("[%d,%d]", start, end);
    }

    public static class IntervalComparator implements Comparator<Interval> {


        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1 == null || o2 == null) {
                return -1;
            }
            return Integer.compare(o1.start, o2.start);
        }
    }
}
