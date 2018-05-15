package practice.leetcode.oj201to210;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 18/1/17.
 */
public class OJ205 {
    public boolean isIsomorphic(String s, String t) {
        String hash1 = myhash(s);
        String hash2 = myhash(t);
        return hash1.equals(hash2);
    }

    private String myhash(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, (char) (count + 'a'));
                count += 1;
            }
            sb.append(map.get(c));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        OJ205 obj = new OJ205();
        System.out.println(obj.isIsomorphic("egg", "add"));//true
        System.out.println(obj.isIsomorphic("foo", "bar"));//false
        System.out.println(obj.isIsomorphic("paper", "title"));//true
    }
}
