package practice.leetcode.oj051to060;

import practice.leetcode.utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/27.
 */
public class OJ056_test {


    public List<Interval> merge(List<Interval> input) {
        if (input.size() <= 1) {
            return input;
        }
        List<Interval> res = new ArrayList<>();
        input.sort((o1, o2) -> o1.start - o2.start);
        Interval pre = input.get(0);
        res.add(pre);

        for (int i = 1; i < input.size(); i++) {
            Interval cur = input.get(i);
            if (cur.start <= pre.end) {
                pre.end = Math.max(cur.end, pre.end);
            } else {
                pre = cur;
                res.add(pre);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        OJ056_test obj = new OJ056_test();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        System.out.println(obj.merge(intervals));//[1,6],[8,10],[15,18].
    }
}
