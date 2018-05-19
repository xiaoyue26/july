package practice.leetcode.oj401to410;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xiaoyue26
 * 从四周往里头扫,
 * 每根柱子的状态变化:
 * 1. 太低了=>注水结冰，转化成高柱子; (顺便记录一下注水量)
 * 2. 不低=>直接转化为新边界.
 */
public class OJ407 {
    private static class Cell {
        public int x, y, h;

        public Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 1 || heightMap[0].length <= 1) {
            return 0;
        }
        Queue<Cell> heap = new PriorityQueue<>((o1, o2) -> o1.h - o2.h);
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        addBorder(m, n, heightMap, visited, heap);
        // bfs:
        int res = 0;
        int dx[] = new int[]{0, 0, -1, 1};
        int dy[] = new int[]{-1, 1, 0, 0};
        int x, y;
        while (!heap.isEmpty()) {
            Cell c = heap.poll();
            for (int i = 0; i < dx.length; i++) {
                x = c.x + dx[i];
                y = c.y + dy[i];
                if (validXY(x, y, visited, m, n)) {
                    Cell newC = new Cell(x, y, heightMap[x][y]);
                    if (newC.h < c.h) {
                        res += c.h - newC.h;
                        newC.h = c.h;
                    }
                    heap.offer(newC);
                    visited[x][y] = true;
                }
            }

        }
        return res;
    }

    private boolean validXY(int x, int y, boolean[][] visited, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        return true;
    }

    private void addBorder(int m, int n, int[][] heightMap, boolean[][] visited, Queue<Cell> heap) {
        for (int i = 0; i < m; i++) {
            heap.offer(new Cell(i, 0, heightMap[i][0]));
            heap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int i = 1; i < n - 1; i++) {
            heap.offer(new Cell(0, i, heightMap[0][i]));
            heap.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
            visited[0][i] = true;
            visited[m - 1][i] = true;
        }
    }


    public static void main(String[] args) {
        OJ407 obj = new OJ407();
        System.out.println(obj.trapRainWater(new int[][]{
                {1, 4, 3, 1, 3, 2}
                , {3, 2, 1, 3, 2, 4}
                , {2, 3, 3, 2, 3, 1}
        }));// 4
    }
}
