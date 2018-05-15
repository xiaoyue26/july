package practice.leetcode.oj051to060;

import practice.leetcode.utils.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/28.
 */
public class OJ057 {
    // intervals is sorted
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<>(Arrays.asList(newInterval));
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
            if(i==0){
                continue;
            }
            Interval pre = intervals.get(i - 1);
            Interval cur = intervals.get(i);
            if (pre.end >= cur.start) {
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

    public static void main(String[] args) {
        OJ057 obj = new OJ057();
        List<Interval> intervals = new ArrayList<>(
                Arrays.asList(
                        new Interval(1, 3)
                        , new Interval(6, 9)
                )
        );//[1,3],[6,9]

        Interval newInterval = new Interval(2, 5);//[2,5]
        System.out.println(obj.insert(intervals, newInterval));//[1,5],[6,9]
        // test 2:
        intervals = new ArrayList<>(
                Arrays.asList(
                        new Interval(1, 2)
                        , new Interval(3, 5)
                        , new Interval(6, 7)
                        , new Interval(8, 10)
                        , new Interval(12, 16)
                )
        );//[1,2],[3,5],[6,7],[8,10],[12,16]
        newInterval = new Interval(4, 9);
        System.out.println(obj.insert(intervals, newInterval));//[1,2],[3,10],[12,16]

        // test3:
        intervals = new ArrayList<>(
                Arrays.asList(
                        new Interval(1, 5)
                )
        );
        newInterval = new Interval(0, 3);
        System.out.println(obj.insert(intervals, newInterval));

    }
}
