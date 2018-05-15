package practice.leetcode.oj331to340;

import java.util.*;

/*
 *  开头固定是JFK, 出一个字母序最小的路线
 * */
public class OJ332 {
    private final String FROM = "JFK";

    private static class Node {
        String to;
        int index;

        public Node(String to, int index) {
            this.to = to;
            this.index = index;
        }
    }

    private int getWeight(Node node) {
        String str = node.to;
        return str.charAt(2) - 'a' + (str.charAt(1) - 'a') * 26 + (str.charAt(0) - 'a') * 26 * 26;
    }

    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        Map<String, List<Node>> map = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            List<Node> pre = map.getOrDefault(from, new ArrayList<>());
            Node node = new Node(to, i);
            pre.add(node);
            map.put(from, pre);
        }
        for (Map.Entry entry : map.entrySet()) {
            List<Node> v = (List<Node>) entry.getValue();
            Collections.sort(v, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    int i1 = getWeight(o1);
                    int i2 = getWeight(o2);
                    return i1 - i2;
                }
            });
        }
        // dfs
        int count = 0;
        String cur = FROM;
        res.add(cur);
        boolean[] visited = new boolean[tickets.length];
        /*while (count < tickets.length) {
            List<String> toS = map.get(cur);
            if (toS == null || toS.size() == 0) {
                // 回溯
                return res;
            }
            cur = toS.remove(0);
            res.add(cur);
            count++;
        }*/
        dfs(cur, res, map, count, tickets.length, visited);
        return res;
    }

    private boolean dfs(String cur, List<String> res, Map<String, List<Node>> map
            , int count, int maxCount, boolean[] visited) {
        if (count >= maxCount) {
            return true;
        }
        List<Node> toList = map.get(cur);
        if (toList == null || toList.size() == 0) {
            return false;
        }
        for (Node n : toList) {
            int index = n.index;
            String to = n.to;
            if (visited[index]) {
                continue;
            }
            res.add(to);
            visited[index] = true;
            boolean flag = dfs(to, res, map, count + 1, maxCount, visited);
            if (flag) {
                return true;
            }
            visited[index] = false;
            res.remove(res.size() - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        OJ332 obj = new OJ332();
        System.out.println(obj.findItinerary(new String[][]{
                {"MUC", "LHR"}
                , {"JFK", "MUC"}
                , {"SFO", "SJC"}
                , {"LHR", "SFO"}
        })); //["JFK", "MUC", "LHR", "SFO", "SJC"]
        System.out.println(obj.findItinerary(new String[][]{
                {"JFK", "SFO"}
                , {"JFK", "ATL"}
                , {"SFO", "ATL"}
                , {"ATL", "JFK"}
                , {"ATL", "SFO"}
        }));//  ["JFK","ATL","JFK","SFO","ATL","SFO"]
        // [["EZE","TIA"],["EZE","AXA"],["AUA","EZE"],["EZE","JFK"],["JFK","ANU"],["JFK","ANU"],["AXA","TIA"],["JFK","AUA"],["TIA","JFK"],["ANU","EZE"],["ANU","EZE"],["TIA","AUA"]]
        System.out.println(obj.findItinerary(new String[][]{
                {"EZE", "TIA"}
                , {"EZE", "AXA"}
                , {"AUA", "EZE"}
                , {"EZE", "JFK"}
                , {"JFK", "ANU"}
                , {"JFK", "ANU"}
                , {"AXA", "TIA"}
                , {"JFK", "AUA"}
                , {"TIA", "JFK"}
                , {"ANU", "EZE"}
                , {"ANU", "EZE"}
                , {"TIA", "AUA"}
        }));
        System.out.println(obj.findItinerary(new String[][]{
                {"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}
        }));
        System.out.println(obj.findItinerary(new String[][]{
                {"JFK", "ATL"}
                , {"ORD", "PHL"}
                , {"JFK", "ORD"}
                , {"PHX", "LAX"}
                , {"LAX", "JFK"}
                , {"PHL", "ATL"}
                , {"ATL", "PHX"}
        }));
    }


}