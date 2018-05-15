package practice.leetcode.oj341to350;

import practice.leetcode.utils.PrintUtils;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author xiaoyue26
 */
public class OJ349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                res.add(i);
                set.remove(i);
            }
        }

        return Arrays.stream(res.toArray()).mapToInt(x -> (int) x).toArray();
        /*int r[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;*/

    }

    public static void main(String[] args) {
        OJ349 obj = new OJ349();
        PrintUtils.print(obj.intersection(new int[]{1, 2, 2, 1}
                , new int[]{2, 2}));// 2
    }
}
