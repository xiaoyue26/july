package practice.leetcode.oj281to290;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiuzhoumu on 2018/2/17.
 */
public class OJ290 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> old = new HashMap<>();
        String[] strs = str.split("\\s+");
        if (pattern.length() != strs.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char cur = pattern.charAt(i);
            if (map.containsKey(cur)) {
                if (!map.get(cur).equals(strs[i])) {
                    return false;
                }
            } else {
                map.put(cur, strs[i]);
            }
            if (old.containsKey(strs[i])) {
                if (!old.get(strs[i]).equals(cur)) {
                    return false;
                }
            } else {
                old.put(strs[i], cur);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OJ290 obj = new OJ290();
        System.out.println(obj.wordPattern("abba", "dog cat cat dog"));
        System.out.println(obj.wordPattern("abba", "dog dog dog dog"));
    }
}
