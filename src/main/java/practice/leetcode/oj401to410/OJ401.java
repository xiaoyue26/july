package practice.leetcode.oj401to410;

import practice.leetcode.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoyue26
 */
public class OJ401 {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new LinkedList<>();
        int[] watch = new int[10];
        binWatch(num, 0, watch, times);
        return times;
    }
    private void binWatch(int n, int i, int[] watch, List<String> times) {
        if (n == 0) {
            String s = getTime(watch);
            if(s != null)
                times.add(s);
            return;
        }
        for (int j = i; j < 10; j++) {
            if (watch[j] == 1)
                continue;
            watch[j] = 1;
            binWatch(n - 1, j+1, watch, times);
            watch[j] = 0;
        }
    }
    private String getTime(int[] watch) {
        int h = 0;
        for (int i = 3; i >= 0; i--) {
            h = h * 2 + watch[i];
        }
        if(h > 11) return null;
        int m = 0;
        for (int i = watch.length - 1; i >= 4; i--) {
            m = m * 2 + watch[i];
        }
        if(m > 59) return null;
        return h + ":" + (m < 10 ? "0" : "") + m;
    }

    public static void main(String[] args) {
        OJ401 obj = new OJ401();
        System.out.println(obj.readBinaryWatch(1));
        //["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
        System.out.println(obj.readBinaryWatch(2));
        System.out.println(obj.readBinaryWatch(7));
        System.out.println(obj.readBinaryWatch(10));
    }
}
