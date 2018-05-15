package practice.leetcode.oj351to360;

import practice.leetcode.utils.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author xiaoyue26
 */
public class OJ352_others {
    public static class SummaryRanges {
        TreeMap<Integer, Interval> tree;

        public SummaryRanges() {
            tree = new TreeMap<>();
        }

        public void addNum(int val) {
            if (tree.containsKey(val)) return;
            Integer l = tree.lowerKey(val);// val左边的
            Integer h = tree.higherKey(val);// val右边的
            if (l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {
                tree.get(l).end = tree.get(h).end;
                tree.remove(h);
            } else if (l != null && tree.get(l).end + 1 >= val) {
                tree.get(l).end = Math.max(tree.get(l).end, val);
            } else if (h != null && h == val + 1) {
                tree.put(val, new Interval(val, tree.get(h).end));
                tree.remove(h);
            } else {
                tree.put(val, new Interval(val, val));
            }
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(tree.values());
        }
    }

    @SuppressWarnings("Duplicates")
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
