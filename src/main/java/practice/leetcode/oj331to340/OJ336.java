package practice.leetcode.oj331to340;

import java.util.*;

/* 可能的情况
 * 1: s1为空,s2回文;或者反过来;
 * 2: s1与s2相反;
 * 3. s1[0:j]回文,s2从左边补,s1剩下的与s2相反;
 * 4. s1[j+1:len-1]回文,s2从右边补,s1剩下的与s2相反.
 * */
public class OJ336 {
    @SuppressWarnings("Duplicates")
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length <= 1) {
            return res;
        }
        //build the map save the key-val pairs: String - idx
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        // case 1:
        if (map.containsKey("")) {
            int blankIdx = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (isPalindrome(words[i])) {
                    if (i == blankIdx) continue;
                    res.add(Arrays.asList(blankIdx, i));
                    res.add(Arrays.asList(i, blankIdx));
                }
            }
        }

        // case2:
        for (int i = 0; i < words.length; i++) {
            String cur_r = reverseStr(words[i]);
            if (map.containsKey(cur_r)) {
                int found = map.get(cur_r);
                if (found == i) continue;
                res.add(Arrays.asList(i, found));
            }
        }

        //case3 : s1[0:j] isPalindrome && s1[j+1:] = reverse(s2) => (s2, s1) // s1.length> s2.length
        //case4 : s1[j+1:] isPalindrome && s1[0:j] = reverse(s2) => (s1, s2) // s1.length> s2.length
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int j = 1; j < cur.length(); j++) {
                String left = cur.substring(0, j);
                String right = cur.substring(j);
                if (isPalindrome(left)) {
                    String reverse_right = reverseStr(right);
                    int found = map.getOrDefault(reverse_right, -1);
                    if (found != i && found != -1) {
                        res.add(Arrays.asList(found, i));
                    }
                }
                if (isPalindrome(right)) {
                    String reverse_left = reverseStr(left);
                    int found = map.getOrDefault(reverse_left, -1);
                    if (found != i && found != -1) {
                        res.add(Arrays.asList(i, found));
                    }
                }
            }
        }

        return res;
    }

    private String reverseStr(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        OJ336 obj = new OJ336();
        System.out.println(obj.palindromePairs(new String[]{
                        "bat", "tab", "cat"
                }
        ));//[[0, 1], [1, 0]]
        // ["battab", "tabbat"]
        System.out.println(obj.palindromePairs(new String[]{
                        "abcd", "dcba", "lls", "s", "sssll"
                }
        ));//[[0, 1], [1, 0], [3, 2], [2, 4]]
        // ["dcbaabcd", "abcddcba", "slls", "llssssll"]

    }
}