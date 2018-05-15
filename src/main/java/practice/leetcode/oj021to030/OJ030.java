package practice.leetcode.oj021to030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyue26 on 17/11/14.
 */
public class OJ030 {

    private void increaseValue(Map<String, Integer> curMap, String str) {
        curMap.put(str, curMap.getOrDefault(str, 0) + 1);
    }

    private void decreaseValue(Map<String, Integer> curMap, String str) {
        Integer value = curMap.getOrDefault(str, 0);
        curMap.put(str, value - 1);
        if (value <= 1) {
            curMap.remove(str);
        }
    }

    public List<Integer> findSubstring(String S, String[] words) {

        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0 || words == null || words.length == 0)
            return res;
        // 每个单词出现的次数:
        Map<String, Integer> map = new HashMap<>();//每种解答需要匹配的
        for (String word : words) {
            increaseValue(map, word);
        }
        int wordLen = words[0].length();
        int num = words.length;
        int totalLen = num * wordLen;
        Map<String, Integer> curMap = new HashMap<>();
        String curStr;
        for (int i = 0; i < S.length() - totalLen + 1; i++) {
            curMap.putAll(map);
            for (int j = i; j < i + totalLen; j += wordLen) {
                curStr = S.substring(j, j + wordLen);
                if (curMap.containsKey(curStr)) {
                    decreaseValue(curMap, curStr);
                } else {
                    break;// failed
                }
            }
            if (curMap.isEmpty()) {
                // record ans
                res.add(i);
            }
            curMap.clear();
        }


        return res;
    }

    public List<Integer> findSubstring_old(String S, String[] words) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0 || words == null || words.length == 0)
            return res;
        // 每个单词出现的次数:
        Map<String, Integer> map = new HashMap<>();//每种解答需要匹配的
        for (String word : words) {
            increaseValue(map, word);
        }
        Map<String, Integer> curMap = new HashMap<>();// 这次已经匹配的
        for (int i = 0; i < words[0].length(); i++) {
            int count = 0;
            int left = i;// 以i为起点试图匹配所有单词
            for (int j = i; j <= S.length() - words[0].length(); j += words[0].length()) {
                String str = S.substring(j, j + words[0].length());// 读取下一个单词
                if (map.containsKey(str)) {
                    increaseValue(curMap, str);
                    if (curMap.get(str) <= map.get(str)) {//单项没超标
                        count++;
                    } else {// 单项超标后:
                        while (curMap.get(str) > map.get(str)) {
                            String temp = S.substring(left, left + words[0].length());
                            if (curMap.containsKey(temp)) {
                                curMap.put(temp, curMap.get(temp) - 1);
                                if (curMap.get(temp) < map.get(temp)) {
                                    count--;
                                }
                            }
                            left += words[0].length();
                        }
                    }
                    if (count == words.length) {
                        res.add(left);
                        //if(left<)
                        String temp = S.substring(left, left + words[0].length());
                        if (curMap.containsKey(temp)) {
                            curMap.put(temp, curMap.get(temp) - 1);
                        }
                        count--;
                        left += words[0].length();
                    }
                } else {// 发现不匹配了:
                    curMap.clear();
                    count = 0;
                    left = j + words[0].length();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OJ030 obj = new OJ030();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(obj.findSubstring(s, words));

    }
}
