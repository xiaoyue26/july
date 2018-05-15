package practice.leetcode.oj351to360;

import practice.leetcode.utils.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xiaoyue26
 */
public class OJ352 {

    static class SummaryRanges {
        private List<Interval> intervals;

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
            intervals = new ArrayList<>();
        }

        public void addNum(int val) {
            Interval i = new Interval(val, val);
            intervals = insert(intervals, i);
        }

        public List<Interval> getIntervals() {
            return intervals;
        }

        @SuppressWarnings("Duplicates")
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            if (intervals.size() == 0) {
                intervals.add(newInterval);
                return intervals;
            }
            int left = 0, right = intervals.size() - 1;
            int mid = left + ((right - left) >> 1);

            while (left <= right) {
                mid = (left + right) >>> 1;
                //left + ((right - left) >> 1);
                if (newInterval.start > intervals.get(mid).start) {
                    left = mid + 1;
                } else if (newInterval.start < intervals.get(mid).start) {
                    right = mid - 1;
                } else {
                    break;
                }
            }
            int beginMerge;
            if (left > right) {
                // not found // into left // 从left-1开始合并
                intervals.add(left, newInterval);
                beginMerge = left;
            } else {
                // into mid // 从mid开始合并
                intervals.add(mid, newInterval);
                beginMerge = mid + 1;
            }
            for (int i = beginMerge; i < intervals.size(); i++) {
                if (i == 0) {
                    continue;
                }
                Interval pre = intervals.get(i - 1);
                Interval cur = intervals.get(i);
                if (pre.end + 1 >= cur.start) {
                    intervals.set(i - 1, null);
                    cur.start = pre.start;
                    cur.end = Math.max(pre.end, cur.end);
                }
            }
            List<Interval> res = new ArrayList<>();
            for (Interval inter : intervals) {
                if (inter != null) {
                    res.add(inter);
                }
            }
            return res;
        }
    }


    public static void main(String[] args) {
        SummaryRanges obj = new SummaryRanges();
        obj.addNum(1);
        obj.addNum(3);
        obj.addNum(7);
        obj.addNum(2);
        obj.addNum(6);
        List<Interval> res = obj.getIntervals();
        System.out.print(res);// [1,3],[6,7]

    }
}
