package practice.leetcode.oj121to130;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/12/24.
 * 自己简化以后的解法. 用循环实现BFS,便于理解.
 */
public class OJ126_new {
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
        // BFS扫描后得到的. key: 某个可达点, val: 下一跳的点. 方向是从begin到end.
        Map<String, List<String>> map = new HashMap<>();
        bfs(wordDict, beginSet, endSet, map);

        List<List<String>> res = new ArrayList<>();
        List<String> tmpRes = new ArrayList<>(Arrays.asList(start));
        dfs(start, end, map, tmpRes, res);
        return res;
    }

    private void bfs(Set<String> dict
            , Set<String> beginSet
            , Set<String> endSet
            , Map<String, List<String>> map) {
        Set<String> tmp;
        boolean direction = true;// 保证方向是从begin到end. (因为有一个加速swap的存在)
        boolean done = false; // 保证只要最短路径
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) { // 从小的set发起BFS,加速. 注释掉这段也能正确,但会慢很多.
                direction = !direction;
                tmp = endSet; // swap
                endSet = beginSet;
                beginSet = tmp;
            }
            dict.removeAll(beginSet);// visited信息得在这层更新,以确保获取所有最短路径.
            dict.removeAll(endSet);
            Set<String> nextLevel = new HashSet<>();// 下一层的set
            for (String beginWord : beginSet) {
                for (int i = 0; i < beginWord.length(); i++) {
                    char[] chars = beginWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char old = chars[i];
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
                        } else if (dict.contains(nextWord)) {// 如果还没到达. 记录一下可达点.
                            nextLevel.add(nextWord);
                            list.add(val);
                            map.put(key, list);
                        }
                        chars[i] = old;
                    }
                }
            }
            if (done) {
                return;
            }
            beginSet = nextLevel;// 更新beginSet.
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
        OJ126_new obj = new OJ126_new();
        List<String> wordList = new ArrayList<>(Arrays.asList(
                //        "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"
                //"a", "c", "b"
                "flail","halon","lexus","joint","pears","slabs","lorie","lapse","wroth","yalow","swear","cavil","piety","yogis","dhaka","laxer","tatum","provo","truss","tends","deana","dried","hutch","basho","flyby","miler","fries","floes","lingo","wider","scary","marks","perry","igloo","melts","lanny","satan","foamy","perks","denim","plugs","cloak","cyril","women","issue","rocky","marry","trash","merry","topic","hicks","dicky","prado","casio","lapel","diane","serer","paige","parry","elope","balds","dated","copra","earth","marty","slake","balms","daryl","loves","civet","sweat","daley","touch","maria","dacca","muggy","chore","felix","ogled","acids","terse","cults","darla","snubs","boats","recta","cohan","purse","joist","grosz","sheri","steam","manic","luisa","gluts","spits","boxer","abner","cooke","scowl","kenya","hasps","roger","edwin","black","terns","folks","demur","dingo","party","brian","numbs","forgo","gunny","waled","bucks","titan","ruffs","pizza","ravel","poole","suits","stoic","segre","white","lemur","belts","scums","parks","gusts","ozark","umped","heard","lorna","emile","orbit","onset","cruet","amiss","fumed","gelds","italy","rakes","loxed","kilts","mania","tombs","gaped","merge","molar","smith","tangs","misty","wefts","yawns","smile","scuff","width","paris","coded","sodom","shits","benny","pudgy","mayer","peary","curve","tulsa","ramos","thick","dogie","gourd","strop","ahmad","clove","tract","calyx","maris","wants","lipid","pearl","maybe","banjo","south","blend","diana","lanai","waged","shari","magic","duchy","decca","wried","maine","nutty","turns","satyr","holds","finks","twits","peaks","teems","peace","melon","czars","robby","tabby","shove","minty","marta","dregs","lacks","casts","aruba","stall","nurse","jewry","knuth"
        ));
        //System.out.println(obj.findLadders("qa", "sq", wordList));
        System.out.println(obj.findLadders("magic", "pearl", wordList));
    }
}
