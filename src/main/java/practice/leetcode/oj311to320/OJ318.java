package practice.leetcode.oj311to320;

import java.util.Arrays;

/**
 * 仅有小写字母。
 * max { len(w1)*len(w2)}  // 其中w1和w2没有相同字母
 * <p>
 * 思路：
 * w1 => int1
 * w2 => int2
 * 一个int= 4个字节 = 32位 表达26个标志绰绰有余
 * int1 & int2 !=0 => 有公共元素
 * <p>
 * 没必要和所有w都不同。因此是：
 * 1+2+3...n-1=(1+n-1)*(n-1)/2
 * O(n^2)
 */
public class OJ318 {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) {
            return 0;
        }
        // Arrays.sort(words, (a, b) -> b.length() - a.length()); // 排序的话，可以提前剪枝

        int max = 0;
        int flags[] = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);

                int add = 1 << (c - 'a');
                if ((flags[i] & add) == 0) {
                    flags[i] += add;
                }
            }
        }
        for (int i = 1; i < flags.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((flags[i] & flags[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        OJ318 obj = new OJ318();
        System.out.println(obj.maxProduct(new String[]{
                "abcw", "baz", "foo", "bar", "xtfn", "abcdef"// "abcw", "xtfn" // 16
        }));
        System.out.println(obj.maxProduct(new String[]{
                "a", "ab", "abc", "d", "cd", "bcd", "abcd"// "ab", "cd" // 4
        }));
        System.out.println(obj.maxProduct(new String[]{
                "a", "aa", "aaa", "aaaa"//  0
        }));
    }
}