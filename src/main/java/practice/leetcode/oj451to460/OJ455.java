package practice.leetcode.oj451to460;

/**
 * @author xiaoyue26
 */

import java.util.Arrays;

public class OJ455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int res = 0;
        for (int i = 0; i < g.length && j < s.length; i++) {
            while (j < s.length) {
                if (s[j] >= g[i]) {
                    res++;
                    j++;
                    break;
                }
                j++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        OJ455 obj = new OJ455();
        System.out.println(obj.findContentChildren(new int[]{
                1, 2, 3
        }, new int[]{
                1, 1
        }));//1
        System.out.println(obj.findContentChildren(new int[]{
                1, 2
        }, new int[]{
                1, 2, 3
        }));//2
    }
}