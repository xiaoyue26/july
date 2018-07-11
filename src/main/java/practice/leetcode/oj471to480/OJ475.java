package practice.leetcode.oj471to480;

import java.util.Arrays;

/**
 * @author xiaoyue26
 */
public class OJ475 {

    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0) {
            return 0;
        }
        if (heaters == null || heaters.length == 0) {
            return Integer.MAX_VALUE;
        }
        int radius = 0;
        Arrays.sort(heaters);
        for (int h : houses) {
            int pos = Arrays.binarySearch(heaters, h);
            if (pos < 0) {
                pos = -pos - 1;
                if (pos < heaters.length) {
                    int distance = heaters[pos] - h;
                    if (pos - 1 >= 0) {
                        distance = Math.min(h - heaters[pos - 1], distance);
                    }
                    radius = Math.max(radius, distance);
                } else {
                    int distance = h - heaters[heaters.length - 1];
                    radius = Math.max(radius, distance);
                }
            }
        }

        return radius;
    }

    public static void main(String[] args) {
        OJ475 obj = new OJ475();
        System.out.println(obj.findRadius(new int[]{
                1, 2, 3
        }, new int[]{
                2
        }));//1
        System.out.println(obj.findRadius(new int[]{
                1, 2, 3, 4
        }, new int[]{
                1, 4
        }));//1

    }
}
