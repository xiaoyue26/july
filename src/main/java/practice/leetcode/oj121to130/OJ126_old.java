package practice.leetcode.oj121to130;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/12/23.
 * 过程:
 * 每次改变一个字母;// update
 * <p>
 * <p>
 * 预设:
 * 所有单词长度一致;
 * 只有小写字母;
 * 无重复;
 * beginWord,endWord不为空,且不相同.
 */
public class OJ126_old {
    private List<List<Integer>> getPermutations(List<Integer> indexs) {
        List<List<Integer>> res = new ArrayList<>();
        if (indexs.size() == 0) {
            return res;
        }
        if (indexs.size() == 1) {
            List<Integer> row = new ArrayList<>(Arrays.asList(indexs.get(0)));
            res.add(row);
            return res;
        }

        for (int i = 0; i < indexs.size(); i++) {
            List<Integer> tmp = new ArrayList<>(indexs);
            Integer cur = tmp.get(i);
            tmp.remove(i);
            List<List<Integer>> curRes = getPermutations(tmp);
            for (List<Integer> row : curRes) {
                row.add(0, cur);
                res.add(row);
            }
        }

        return res;
    }

    private int minSize;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        minSize = Integer.MAX_VALUE;
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : wordList) {
            wordMap.put(word, getDiff(word, endWord));
        }
        tmp.add(beginWord);
        Set<String> used = new HashSet<>();
        dfs(beginWord, endWord, wordMap, res, tmp, used);
        List<List<String>> newRes = new ArrayList<>();
        for (List<String> row : res) {
            if (row.size() <= minSize) {
                newRes.add(row);
            }
        }
        return newRes;
    }

    int count = 0;

    private void dfs(String beginWord, String endWord, Map<String, Integer> wordMap
            , List<List<String>> res, List<String> tmp, Set<String> used) {
        int diff = getDiff(beginWord, endWord);
        if (diff <= 0) {
            minSize = Math.min(minSize, tmp.size());
            if (tmp.size() <= minSize) {
                System.out.print(count++);
                System.out.print(":");
                System.out.println(tmp);
                res.add(new ArrayList<>(tmp));
            }
            return;
        }

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            String w = entry.getKey();
            if (used.contains(w)) {
                continue;
            }
            int curDiff = getDiff(w, beginWord);

            if (curDiff == 1) {
                int endDiff = getDiff(w, endWord);
                if (endDiff > diff) {
                    continue;
                }
                used.add(w);
                tmp.add(w);
                dfs(w, endWord, wordMap, res, tmp, used);
                tmp.remove(tmp.size() - 1);
                used.remove(w);
            }
        }
    }

    private int getDiff(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        OJ126_old obj = new OJ126_old();
        List<String> wordList = new ArrayList<>(Arrays.asList(
                //"hot", "dot", "dog", "lot", "log", "cog"
                //"hot", "cog"
                "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"
        ));
        //System.out.println(obj.findLadders("hit", "cog", wordList));
        System.out.println(obj.findLadders("qa", "sq", wordList));
        /* res:
        * [
            ["hit","hot","dot","dog","cog"],
            ["hit","hot","lot","log","cog"]
          ]
        * */
    }
}
