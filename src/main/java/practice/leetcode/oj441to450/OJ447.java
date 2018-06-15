package practice.leetcode.oj441to450;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoyue26
 * 3个点组成一个结果(等差数列)
 * 问有几个结果。
 * <p>
 * 选一个点B作为中点，距B距离为d的有n个，则结果有C(n,2)*2=n*(n-1)个。
 */
public class OJ447 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> distanceCount = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int d = getDistance(points[i], points[j]);
                    Integer old = distanceCount.getOrDefault(d, 0);
                    distanceCount.put(d, old + 1);
                }
            }
            for (Integer n : distanceCount.values()) {
                res += n * (n - 1);
            }
            distanceCount.clear();
        }


        return res;
    }

    private int getDistance(int[] pointA, int[] pointB) {
        int dx = pointA[0] - pointB[0];
        int dy = pointA[1] - pointB[1];
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) {
        OJ447 obj = new OJ447();
        System.out.println(obj.numberOfBoomerangs(new int[][]{
                {0, 0}
                , {1, 0}
                , {2, 0}
        }));
    }
}
