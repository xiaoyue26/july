package practice.leetcode.oj461to470;

/**
 * @author xiaoyue26
 */
public class OJ463 {

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        res -= 2;
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        res -= 2;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OJ463 obj = new OJ463();
        System.out.println(obj.islandPerimeter(new int[][]{
                {0, 1, 0, 0}
                , {1, 1, 1, 0}
                , {0, 1, 0, 0}
                , {1, 1, 0, 0}
        }));
    }
}