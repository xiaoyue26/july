package practice.leetcode.oj491to500;

import practice.leetcode.utils.PrintUtils;

/**
 * @author xiaoyue26
 */
public class OJ492 {
    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        for (int i = 1; area / i >= i; i++) {
            if (area % i == 0) {
                res[0] = area / i;
                res[1] = i;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        OJ492 obj = new OJ492();
        PrintUtils.print(obj.constructRectangle(4));
        PrintUtils.print(obj.constructRectangle(8));
    }
}
