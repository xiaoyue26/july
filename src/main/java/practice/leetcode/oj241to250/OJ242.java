package practice.leetcode.oj241to250;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 18/2/7.
 */
public class OJ242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer pre = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), pre + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            Integer pre = map.getOrDefault(t.charAt(i), 0);
            if (pre == 0) {
                return false;
            }
            map.put(t.charAt(i), pre - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        OJ242 obj = new OJ242();
        System.out.println(obj.isAnagram("anagram", "nagaram"));//true
        System.out.println(obj.isAnagram("rat", "car"));//false
    }
}
