package practice.leetcode.utils;

/**
 * Created by xiaoyue26 on 18/1/2.
 */
public class Point {
    public int x;
    public int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int a, int b) {
        x = a;
        y = b;
    }
    @Override
    public String toString(){
        return String.format("(%d,%d)",x,y);
    }

    public static Point[] genPoints(int[] input) {
        Point[] res = new Point[input.length / 2];
        int i = 0;
        while (i < input.length - 1) {
            res[i / 2] = new Point(input[i], input[i + 1]);
            i += 2;
        }
        return res;
    }


    public static void main(String[] args) {
        Point obj = new Point();
        System.out.println("there");
    }
}
