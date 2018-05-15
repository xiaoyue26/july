package practice.leetcode.oj201to210;

import practice.leetcode.utils.PrintUtils;

import java.util.*;

/**
 * Created by xiaoyue26 on 18/1/20.
 */
public class OJ210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[][] matrix = new boolean[numCourses][numCourses];
        int[] inDegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            int i = edge[0];
            int j = edge[1];
            if (!matrix[j][i]) {
                inDegree[i]++;
            }
            matrix[j][i] = true;

        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            res[index++] = i;
            for (int j = 0; j < numCourses; j++) {
                if (matrix[i][j]) {
                    inDegree[j]--;
                    if (inDegree[j] == 0) {
                        queue.offer(j);
                    }
                }
            }
        }
        if (index == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        OJ210 obj = new OJ210();
        int[][] prerequisites = new int[][]{
                {5, 8}
                , {3, 5}
                , {1, 9}
                , {4, 5}
                , {0, 2}
                , {1, 9}
                , {7, 8}
                , {4, 9}
        };
        // 10
        //[[5,8],[3,5],[1,9],[4,5],[0,2],[1,9],[7,8],[4,9]]
        PrintUtils.print(obj.findOrder(10, prerequisites));
    }
}
