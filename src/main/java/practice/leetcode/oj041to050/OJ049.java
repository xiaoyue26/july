package practice.leetcode.oj041to050;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/11/25.
 */
public class OJ049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        char[][] counts = new char[strs.length][26];
        Map<String, Integer> locMap = new HashMap<>();
        int cur;
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                cur = strs[i].charAt(j) - 'a';
                counts[i][cur]++;
            }
            String key = String.valueOf(counts[i]);
            if (locMap.containsKey(key)) {
                int index = locMap.get(key);
                res.get(index).add(strs[i]);
            } else {
                locMap.put(key, res.size());
                res.add(new ArrayList<>(Arrays.asList(strs[i])));
            }
        }


        return res;
    }

    public static void main(String[] args) {
        OJ049 obj = new OJ049();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(obj.groupAnagrams(strs));

    }
}
