package practice.leetcode.oj141to150;

import practice.leetcode.utils.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 18/1/2.
 * 最多点一线.
 * 三点一线:
 * (x2-x1)*(y3-y1)=(x3-x1)*(y2-y1)
 */
public class OJ149 {
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int overlap = 0;
            int lineMax = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = getGcd(x, y);
                x /= gcd;
                y /= gcd;
                String key = String.format("%d/%d", x, y);
                Integer count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);
                lineMax = Math.max(lineMax, count);
            }
            res = Math.max(res, lineMax + overlap + 1);
        }
        return res;
    }

    private int getGcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return getGcd(y, x % y);
    }

    public static void main(String[] args) {
        OJ149 obj = new OJ149();
        Point[] points = Point.genPoints(new int[]{
                1, 3
                , 2, 4
                , 3, 6
        });
        System.out.println(obj.maxPoints(points));
    }
}
