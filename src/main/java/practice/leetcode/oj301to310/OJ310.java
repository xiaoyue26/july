package practice.leetcode.oj301to310;

import java.util.*;

/**
 * Created by xiaoyue26 on 18/3/1.
 */
public class OJ310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return new ArrayList<>(Arrays.asList(0));
        }

        List<Set<Integer>>adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        OJ310 obj = new OJ310();
        System.out.println(obj.findMinHeightTrees(4, new int[][]{
                        {1, 0}
                        , {1, 2}
                        , {1, 3}
                }
        ));// 1
        System.out.println(obj.findMinHeightTrees(6, new int[][]{
                        {0, 3}
                        , {1, 3}
                        , {2, 3}
                        , {4, 3}
                        , {5, 4}
                }
        ));// 3, 4
    }
}
