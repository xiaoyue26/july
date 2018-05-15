package practice.leetcode.oj121to130;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/12/23.
 */
public class OJ126 {
    public List<List<String>> findLadders(String start, String end, List<String> dict) {
        // 可以用的踏板
        Set<String> wordDict = new HashSet<>(dict);
        if (!wordDict.contains(end)) {
            return new ArrayList<>();
        }
        // 起点集合和终点集合. 互相BFS (也可以单向,但会慢很多)
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(start);
        endSet.add(end);
        // BFS扫描后得到的. key: 某个可达点, val: 下一跳的点
        Map<String, List<String>> map = new HashMap<>();
        bfs(wordDict, beginSet, endSet, map, true);

        List<List<String>> res = new ArrayList<>();
        List<String> tmpRes = new ArrayList<>(Arrays.asList(start));
        dfs(start, end, map, tmpRes, res);
        return res;
    }

    private boolean bfs(Set<String> dict
            , Set<String> beginSet
            , Set<String> endSet
            , Map<String, List<String>> map
            , boolean direction) {
        if (beginSet.isEmpty()) {
            return false;
        }

        if (beginSet.size() > endSet.size()) { // 从小的set发起BFS,加速. 注释掉这段也能正确,但会慢很多.
            return bfs(dict, endSet, beginSet, map, !direction);// 反向搜更快.
        }
        // 记录一下哪些是已经visit的. 节约一个visited集合变量
        dict.removeAll(beginSet);
        dict.removeAll(endSet);
        // 只收集最短路径.
        boolean done = false;
        // 下一层的set
        Set<String> nextLevel = new HashSet<>();

        for (String beginWord : beginSet) {
            for (int i = 0; i < beginWord.length(); i++) {
                char[] chars = beginWord.toCharArray();
                // change one character for every position
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String nextWord = new String(chars);
                    String key, val;
                    if (direction) {// 区分方向.
                        key = beginWord;
                        val = nextWord;
                    } else {
                        key = nextWord;
                        val = beginWord;
                    }
                    List<String> list = map.getOrDefault(key, new ArrayList<>());
                    if (endSet.contains(nextWord)) {// 到达了终点域
                        done = true;
                        list.add(val);// 记录一下可达点和下一跳.
                        map.put(key, list);// 放回去.
                    }
                    else if (dict.contains(nextWord)) {// 如果还没到达. 记录一下可达点.
                        nextLevel.add(nextWord);
                        list.add(val);
                        map.put(key, list);
                    }
                }
            }
        }
        if(done){
            return true;
        }
        else{
            return bfs(dict, endSet, nextLevel, map, !direction);
        }
    }

    private void dfs(String start, String end
            , Map<String, List<String>> map // key: 某个可达点 val: 从这个点出发的下一条集合.
            , List<String> tmpRes
            , List<List<String>> res) {
        if (start.equals(end)) { // 已经到达结果,存一下结果.
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        if (!map.containsKey(start)) {// 这个点根本不可能到达.返回.
            return;
        }
        List<String> row = map.get(start);// 可达的下一步都有啥.
        for (String nextLadder : row) {
            tmpRes.add(nextLadder);
            dfs(nextLadder, end, map, tmpRes, res);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        OJ126 obj = new OJ126();
        List<String> wordList = new ArrayList<>(Arrays.asList(
                "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"
        ));
        System.out.println(obj.findLadders("qa", "sq", wordList));

    }
}
