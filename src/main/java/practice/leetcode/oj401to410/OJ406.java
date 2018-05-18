package practice.leetcode.oj401to410;

import practice.leetcode.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xiaoyue26
 */
public class OJ406 {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];// ASC
            } else {
                return a[1] - b[1];// DSC
            }
        });
        for (int[] p : people) {
            pq.offer(p);
        }
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            res.add(p[1], p);
        }

        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        OJ406 obj = new OJ406();
        PrintUtils.print(obj.reconstructQueue(new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        }));// {5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}

        PrintUtils.print(obj.reconstructQueue(new int[][]{
                {5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}
        }));
    }
}
