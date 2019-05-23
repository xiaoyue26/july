package practice.leetcode.oj001to010;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoyue26 on 17/10/29.
 */
public class OJ003 {
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int maxLen = 1, begin = 0;
        Map<Character, Integer> visited = new HashMap<>();
        visited.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            Integer pos = visited.get(s.charAt(i));
            if (pos == null || pos < begin) { // new char:
                maxLen = Math.max(maxLen, i - begin + 1);
                visited.put(s.charAt(i), i);
            } else { // 重新开始: 无需清理visited,因为上面有限定pos<begin的也算新增
                begin = pos + 1;
                visited.put(s.charAt(i), i);
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String input) {
        Map<Character, Integer> hashmap = new HashMap<>();
        int begin = 0;
        int end = 0;
        int longetstLength = end - begin;
        for (int i = 0; i < input.length(); i++) {
            Character cur = input.charAt(i);
            if (!hashmap.containsKey(cur) || hashmap.get(cur) < begin) {// didn't_appear_in_this_substring
                end = i + 1;
                longetstLength = Math.max(end - begin, longetstLength);
            } else {
                begin = hashmap.get(cur) + 1;
                //end = i + 1;
            }
            hashmap.put(cur, i);// update_char_map

        }
        return longetstLength;
    }

    public static void main(String[] args) {
        OJ003 oj = new OJ003();
        System.out.println(oj.lengthOfLongestSubstring("abcabcbb"));//3
        System.out.println(oj.lengthOfLongestSubstring("bbbbb"));//1
        System.out.println(oj.lengthOfLongestSubstring("pwwkew"));//3

    }
}
