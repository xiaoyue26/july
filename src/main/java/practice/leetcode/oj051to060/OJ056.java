package practice.leetcode.oj051to060;

import practice.leetcode.utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/27.
 */
public class OJ056 {
    public static class IntervalComparator implements Comparator<Interval> {


        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            return Integer.compare(o1.start, o2.start);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals, new IntervalComparator());

        for (int i = 1; i < intervals.size(); i++) {
            Interval pre = intervals.get(i - 1);
            Interval cur = intervals.get(i);
            if (pre.end >= cur.start) {
                intervals.set(i - 1, null);
                cur.start = pre.start;
                cur.end = Math.max(pre.end, cur.end);
            } else {
                // do nothing
            }
        }
        List<Interval> res = new ArrayList<>();
        for (Interval cur : intervals) {
            if (cur != null) {
                res.add(cur);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        OJ056 obj = new OJ056();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        System.out.println(obj.merge(intervals));//[1,6],[8,10],[15,18].
    }
}
