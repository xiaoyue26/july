package practice.leetcode.oj221to230;

/**
 * Created by xiaoyue26 on 18/1/28.
 */
public class OJ223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        int up = Math.min(D, H);
        int down = Math.max(F, B);
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        //If overlap
        int overlap = 0;
        if (right > left && up > down) {
            overlap = (right - left) * (up - down);
        }

        return area1 + area2 - overlap;
    }

    public static void main(String[] args) {
        OJ223 obj = new OJ223();
        System.out.println(obj.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(obj.computeArea(-2, -2, 2, 2, -3, -3, 3, -1));

    }
}
