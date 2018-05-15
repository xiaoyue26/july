package practice.leetcode.oj391to400;

import java.util.*;

/**
 * @author xiaoyue26
 * 看s的字母是否都按顺序在t中
 * case 1: t很长,s比较短
 * // 遍历一下
 * <p>
 * case 2: s很多,t保持不变
 * // 预处理t,以便跳跃查找s中的字符
 */
public class OJ392 {
    public boolean isSubsequence_case1(String s, String t) {
        char c1[] = s.toCharArray();
        char c2[] = t.toCharArray();
        int i = 0, j = 0;
        while (i < c1.length && j < c2.length) {
            if (c1[i] == c2[j]) {
                i++;
            }
            j++;
        }
        return i == c1.length;
    }

    Map<String, Map<Character, List<Integer>>> memory = new HashMap<>();

    public boolean isSubsequence(String s, String t) {// case2
        char c1[] = s.toCharArray();
        Map<Character, List<Integer>> tInfo = memory.getOrDefault(t, init(t));
        int i = 0, pre = -1;
        while (i < c1.length) {
            List<Integer> list = tInfo.getOrDefault(c1[i], null);
            if (list == null) {
                return false;
            }
            pre = binarySearch(list, pre, 0, list.size() - 1);
            if (pre == -1) {
                return false;
            }
            ++i;
        }
        return i == c1.length;
    }

    private int binarySearch(List<Integer> list, int pre, int left, int right) {
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (list.get(mid) <= pre) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        if (left >= list.size()) {
            return -1;
        }
        if (list.get(left) > pre) {
            return list.get(left);
        }
        return -1;
    }

    private Map<Character, List<Integer>> init(String t) {
        Map<Character, List<Integer>> info = new HashMap<>();
        char cs[] = t.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            List<Integer> list = info.getOrDefault(cs[i], new ArrayList<>());
            list.add(i);
            info.put(cs[i], list);
        }
        return info;
    }

    public static void main(String[] args) {
        OJ392 obj = new OJ392();
        System.out.println(obj.isSubsequence("ace", "abcde"));// true
        System.out.println(obj.isSubsequence("aec", "abcde"));// false
        System.out.println(obj.isSubsequence("abc", "ahbgdc"));// true
        System.out.println(obj.isSubsequence("axc", "ahbgdc"));// false
    }
}
