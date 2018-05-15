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
        if (s == null || s.equals("")) {
            return 0;
        }
        int max = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Set<Character> hashSet = new HashSet<>();
            int curMax = 1;
            hashSet.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (hashSet.contains(chars[j])) {
                    break;
                }
                curMax += 1;
                hashSet.add(chars[j]);
            }
            max = Math.max(curMax, max);
        }


        return max;
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
