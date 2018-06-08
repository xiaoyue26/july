package practice.leetcode.oj431to440;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoyue26
 */
public class OJ438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s == null || p == null || s.length() == 0||s.length()<p.length()) {
            return res;
        }
        int pCounters[] = new int[26];
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        for (char c : charP) {
            pCounters[c - 'a']++;
        }
        int diff = p.length();
        for (int i = 0; i < p.length(); i++) {
            char c = charS[i];
            if (pCounters[c - 'a'] > 0) {
                diff--;
            } else {
                diff++;
            }
            pCounters[c - 'a']--;
        }
        if (diff == 0) {
            res.add(0);
        }
        char c;
        for (int i = p.length(); i < s.length(); i++) {
            if (charS[i - p.length()] == charS[i]) {

            } else {
                // out:
                c = charS[i - p.length()];
                if (pCounters[c - 'a'] < 0) {
                    diff--;
                } else { // >=0
                    diff++;
                }
                pCounters[c - 'a']++;
                // in:
                c = charS[i];
                if (pCounters[c - 'a'] > 0) {
                    diff--;
                } else {
                    diff++;
                }
                pCounters[c - 'a']--;
            }
            if (diff == 0) {
                res.add(i - p.length() + 1);
            }

        }


        return res;
    }

    public static void main(String[] args) {
        OJ438 obj = new OJ438();
        System.out.println(obj.findAnagrams("cbaebabacd", "abc"));// 0,6
        System.out.println(obj.findAnagrams("abab", "ab"));//0,1,2
    }
}
