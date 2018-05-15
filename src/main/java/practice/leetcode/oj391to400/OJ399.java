package practice.leetcode.oj391to400;

import practice.leetcode.utils.PrintUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xiaoyue26
 * 不存在的答案返回-1.0
 */
public class OJ399 {
    private static class Node {
        String name;
        public final Map<Node, Double> neibors;

        private Node(String name) {
            this.name = name;
            this.neibors = new HashMap<>();
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Node> existNodes = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] eq = equations[i];
            double v = values[i];
            Node node1 = existNodes.getOrDefault(eq[0], new Node(eq[0]));
            Node node2 = existNodes.getOrDefault(eq[1], new Node(eq[1]));
            node1.neibors.put(node2, v);
            node2.neibors.put(node1, 1 / v);
            existNodes.put(eq[0], node1);
            existNodes.put(eq[1], node2);
        }

        double[] res = new double[queries.length];

        for (int i = 0; i < res.length; i++) {
            if (!existNodes.containsKey(queries[i][0]) || !existNodes.containsKey(queries[i][1])) {
                res[i] = -1;
            } else if (queries[i][0].equals(queries[i][1])) {
                res[i] = 1;
            } else {
                Set<Node> visited = new HashSet<>();
                double[] statusAndRes = cal(existNodes.get(queries[i][0]), queries[i][1], 1, visited);
                res[i] = statusAndRes[1];
            }
        }


        return res;
    }

    private double[] cal(Node begin, String target, double preResult, Set<Node> visited) {
        visited.add(begin);
        Map<Node, Double> neibors = begin.neibors;
        for (Map.Entry<Node, Double> entry : neibors.entrySet()) {
            Node next = entry.getKey();
            if (visited.contains(next)) {
                continue;
            }
            double value = entry.getValue();
            if (next.name.equals(target)) {
                return new double[]{0, preResult * value};
            }
            double[] tryDfs = cal(next, target, preResult * value, visited);
            if (tryDfs[0] != -1) {
                return tryDfs;
            }
        }
        visited.remove(begin);
        return new double[]{-1, -1};
    }


    public static void main(String[] args) {
        OJ399 obj = new OJ399();
        PrintUtils.print(obj.calcEquation(new String[][]{
                {"a", "b"}, {"b", "c"},
        }, new double[]{
                2.0, 3.0
        }, new String[][]{
                {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}
        }));// 6.0, 0.5, -1.0, 1.0, -1.0
    }
}
