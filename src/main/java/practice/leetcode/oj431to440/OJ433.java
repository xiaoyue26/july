package practice.leetcode.oj431to440;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoyue26
 * 最短路径，用bfs
 */
public class OJ433 {
    public int minMutation(String start, String end, String[] bank) {

        Map<Integer, List<Integer>> middile = new HashMap<>();
        int diff;
        List<Integer> tmp;
        boolean[] visited = new boolean[bank.length];
        int endIndex = -1;
        for (int i = 0; i < bank.length; i++) {
            diff = diff(start, bank[i]);
            tmp = middile.getOrDefault(diff, new LinkedList<>());
            tmp.add(i);
            middile.put(diff, tmp);
            if (bank[i].equals(end)) {
                endIndex = i;
            }
        }
        if (endIndex == -1) {
            return -1;
        }

        List<Node> curLevel = new LinkedList<>();
        List<Node> nextLevel = new LinkedList<>();
        int step = 0;
        List<Node> tmpLevel;
        curLevel.add(new Node(0, start));
        while (curLevel.size() > 0) {
            step += 1;
            for (Node node : curLevel) {
                int curDiff = node.diff;
                if (middile.containsKey(curDiff + 1)) {
                    tmp = middile.get(curDiff + 1);
                    if (getNextLevel(tmp, nextLevel, bank, visited, node.cur, start, endIndex)) {
                        return step;
                    }
                }
                if (middile.containsKey(curDiff - 1)) {
                    tmp = middile.get(curDiff - 1);
                    if (getNextLevel(tmp, nextLevel, bank, visited, node.cur, start, endIndex)) {
                        return step;
                    }
                }
            }
            tmpLevel = curLevel;
            curLevel = nextLevel;
            nextLevel = tmpLevel;
            nextLevel.clear();

        }


        return -1;
    }

    private boolean getNextLevel(List<Integer> tmp, List<Node> nextLevel, String[] bank
            , boolean[] visited, String cur, String start, int endIndex) {
        for (Integer i : tmp) {
            if (!visited[i]) {
                if (diff(bank[i], cur) == 1) {
                    if (i.equals(endIndex)) {
                        return true;
                    }
                    nextLevel.add(new Node(diff(start, bank[i]), bank[i]));
                    visited[i] = true;
                }
            }
        }
        return false;

    }

    private class Node {
        int diff;
        String cur;

        public Node(int diff, String cur) {
            this.diff = diff;
            this.cur = cur;
        }
    }

    private int diff(String start, String end) {
        int diff = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }


    public static void main(String[] args) {
        OJ433 obj = new OJ433();
        System.out.println(obj.minMutation("AACCGGTT", "AACCGGTA"
                , new String[]{"AACCGGTA"}));//1
        System.out.println(obj.minMutation("AACCGGTT", "AAACGGTA"
                , new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"})); //2
        System.out.println(obj.minMutation("AAAAACCC", "AACCCCCC"
                , new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));//3
    }
}
