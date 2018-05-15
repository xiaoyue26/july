package practice.leetcode.oj081to090;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/12/9.
 */
public class OJ087 {
    public static Map<String, Set<String>> dict = new HashMap<>();

    public boolean isScramble_old(String s1, String s2) {// 超时
        dict.clear();
        Set<String> res = buildScamble(s1);
        if (res.contains(s2)) {
            return true;
        }
        return false;
    }

    private Set<String> buildScamble(String s) {
        if (dict.containsKey(s)) {
            return dict.get(s);
        }
        Set<String> res = new HashSet<>();
        if (s.length() == 1) {
            res.add(s);
            dict.put(s,res);
            return res;
        }
        for (int i = 1; i < s.length(); i++) {
            Set<String> r1 = buildScamble(s.substring(0, i));
            Set<String> r2 = buildScamble(s.substring(i));
            for (String rr1 : r1) {
                for (String rr2 : r2) {
                    res.add(rr1 + rr2);
                    res.add(rr2 + rr1);
                }
            }
        }
        dict.put(s,res);
        return res;
    }

    public boolean isScramble(String s1, String s2) {// no dp
        if (s1.equals(s2))
            return true;

        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (letters[i] != 0)
                return false;
        // check letter over
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        OJ087 obj = new OJ087();
        System.out.println(obj.isScramble("abcdefghij", "efghijcadb"));
    }
}
