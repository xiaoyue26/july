package practice.leetcode.oj451to460;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xiaoyue26
 */
public class OJ452 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int res = 1;
        int curShoot = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (curShoot >= points[i][0]) {
                continue;
            }
            res += 1;
            curShoot = points[i][1];
        }

        return res;
    }

    public static void main(String[] args) {
        OJ452 obj = new OJ452();
        System.out.println(obj.findMinArrowShots(new int[][]{
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        }));
    }
}
