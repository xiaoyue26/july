package practice.leetcode.oj191to200;

/**
 * Created by xiaoyue26 on 18/1/15.
 */
public class OJ200 {


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] count = new int[]{0};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, i, j, count, visited);
            }
        }
        return count[0];
    }

    private void dfs(char[][] grid, int i, int j, int[] count, boolean[][] visited) {
        if (grid[i][j] == 0 || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        count[0]++;
        visited[i][j] = true;
        tagAround(grid, i + 1, j, visited);
        tagAround(grid, i - 1, j, visited);
        tagAround(grid, i, j + 1, visited);
        tagAround(grid, i, j - 1, visited);
    }

    private void tagAround(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if(grid[i][j]=='1'||grid[i][j]==1){
            tagAround(grid, i + 1, j, visited);
            tagAround(grid, i - 1, j, visited);
            tagAround(grid, i, j + 1, visited);
            tagAround(grid, i, j - 1, visited);
        }
    }

    public static void main(String[] args) {
        OJ200 obj = new OJ200();
        System.out.println(obj.numIslands(new char[][]{
                {1, 1, 1, 1, 0}
                , {1, 1, 0, 1, 0}
                , {1, 1, 0, 0, 0}
                , {0, 0, 0, 0, 0}
        }));//1
        System.out.println(obj.numIslands(new char[][]{
                {1, 1, 0, 0, 0}
                , {1, 1, 0, 0, 0}
                , {0, 0, 1, 0, 0}
                , {0, 0, 0, 1, 1}
        }));//3
    }
}
