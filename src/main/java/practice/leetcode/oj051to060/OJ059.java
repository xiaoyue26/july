package practice.leetcode.oj051to060;

import practice.leetcode.utils.PrintUtils;

/**
 * Created by xiaoyue26 on 17/11/29.
 */
public class OJ059 {
    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return new int[0][0];
        }
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, up = 0, down = n - 1;
        int i = 0, j = 0;
        int direct[] = {0, 1};
        int count = 1;
        while (count <= n * n) {
            res[i][j] = count++;
            if (i + direct[0] > down) {
                right--;
                turn(direct);
            } else if (i + direct[0] < up) {
                left++;
                turn(direct);
            } else if (j + direct[1] > right) {
                up++;
                turn(direct);
            } else if (j + direct[1] < left) {
                down--;
                turn(direct);
            }
            i += direct[0];
            j += direct[1];
        }
        return res;
    }

    private void turn(int[] direct) {
        if (direct[0] == 0) {
            direct[0] = direct[1];
            direct[1] = 0;
        } else {// dirct[0]!=0
            direct[1] = -direct[0];
            direct[0] = 0;
        }
    }

    public static void main(String[] args) {
        OJ059 obj = new OJ059();
        PrintUtils.print(obj.generateMatrix(1));
        PrintUtils.print(obj.generateMatrix(2));
        PrintUtils.print(obj.generateMatrix(3));
        PrintUtils.print(obj.generateMatrix(4));
        PrintUtils.print(obj.generateMatrix(5));
    }
}
