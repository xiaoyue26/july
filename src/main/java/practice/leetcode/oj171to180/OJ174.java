package practice.leetcode.oj171to180;

/**
 * Created by xiaoyue26 on 18/1/10.
 * 找一条路,让过程中极小值最大.
 * 注意不能选结果最大HP的路.
 */
public class OJ174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length < 1 || dungeon[0].length < 1) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] minHp = new int[m][n];
        minHp[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 1 : 1 - dungeon[m - 1][n - 1];
        for (int i = m - 2; i >= 0; --i) {
            minHp[i][n - 1] = minHp[i + 1][n - 1] - dungeon[i][n - 1];
            minHp[i][n - 1] = Math.max(1, minHp[i][n - 1]);
        }
        for (int j = n - 2; j >= 0; --j) {
            minHp[m - 1][j] = minHp[m - 1][j + 1] - dungeon[m - 1][j];
            minHp[m - 1][j] = Math.max(1, minHp[m - 1][j]);
        }
        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                minHp[i][j] = Math.min(minHp[i][j + 1], minHp[i + 1][j]) - dungeon[i][j];
                minHp[i][j] = Math.max(1, minHp[i][j]);
            }
        }
        return minHp[0][0];

    }

    public static void main(String[] args) {
        OJ174 obj = new OJ174();
        int[][] dungeon = new int[][]{
                //{-2, -3, 3}
                //, {-5, -10, 1}
                //, {10, 30, -5}
                {1, -3, 3}
                , {0, -2, 0}
                , {-3, -3, -3}
        };
        System.out.println(obj.calculateMinimumHP(dungeon));
    }
}
