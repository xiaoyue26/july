package practice.leetcode.oj471to480;

import java.util.*;
/**
 * @author xiaoyue26
 * 用hashSet: O(1)
 * 用字典树: O(k),内存开销更大
 * */
public class OJ472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new LinkedList<>();
        Set<String> inputs = new HashSet<>(Arrays.asList(words));
        for (String w : words) {
            if (isConcated(inputs, w)) {
                res.add(w);
            }
        }
        return res;
    }

    private boolean isConcated(Set<String> inputs, String w) {
        for (int i = 1; i < w.length(); i++) {
            if (inputs.contains(w.substring(0, i))) {
                String rightStr = w.substring(i);
                if (inputs.contains(rightStr)
                        || isConcated(inputs, rightStr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OJ472 obj = new OJ472();
        System.out.println(obj.findAllConcatenatedWordsInADict(
                new String[]{
                        "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"
                }
        ));
        System.out.println(obj.findAllConcatenatedWordsInADict(
                new String[]{
                        "a", "b", "ab", "abc"
                }
        ));
    }
}