package practice.leetcode.oj271to280;

import java.util.Arrays;

/**
 * Created by jiuzhoumu on 2018/2/11.
 */
public class OJ274 {

    public int hIndex_sort(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        for (int i = 0; i < citations.length; ) {
            if (citations[i] >= res + 1 && (citations.length - i) >= res + 1) {
                res++;
            } else {
                ++i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OJ274 obj = new OJ274();
        System.out.println(obj.hIndex(new int[]{
                3, 1, 0, 6, 5
        }));
    }

    public int hIndex(int[] citations) {
        int L = citations.length;
        if (L < 1) return 0;
        int[] counts = new int[L + 1];
        for (int i : citations) {
            if (i > L) counts[L]++;
            else counts[i]++;
        }
        int res = 0;
        for (int k = L; k >= 0; k--) {
            res += counts[k];
            if (res >= k) return k;
        }
        return 0;
    }
}
