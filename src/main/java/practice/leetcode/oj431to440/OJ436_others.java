package practice.leetcode.oj431to440;

import practice.leetcode.utils.Interval;
import practice.leetcode.utils.PrintUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoyue26
 */
public class OJ436_others {

    public int[] findRightInterval(Interval[] intervals) {
        if(intervals==null || intervals.length==0) return new int[0];
        final int N = intervals.length;
        int[] res = new int[N];
        int[] starts = new int[N];
        Map<Integer, Integer> map = new HashMap<>(N);
        for(int i=0; i<N; i++){
            starts[i] = intervals[i].start;
            map.put(intervals[i].start, i);
        }
        Arrays.sort(starts);
        for(int i=0; i<N; i++){
            int index = Arrays.binarySearch(starts, intervals[i].end);
            if(index<0) index = -(index+1);
            if(index>=N) {
                res[map.get(intervals[i].start)] = -1;
            } else {
                res[map.get(intervals[i].start)] = map.get(starts[index]);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        OJ436_others obj = new OJ436_others();
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
