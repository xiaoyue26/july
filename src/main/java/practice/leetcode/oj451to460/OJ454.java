package practice.leetcode.oj451to460;

/**
 * @author xiaoyue26
 */

import java.util.HashMap;
import java.util.Map;

public class OJ454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> cdMap = new HashMap<>();
        for (int c : C) {
            for (int d : D) {
                Integer old = cdMap.getOrDefault(-c - d, 0);
                cdMap.put(-c - d, old + 1);
            }
        }


        int res = 0;
        int tmp;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                tmp = cdMap.getOrDefault(A[i] + B[j], 0);
                res += tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OJ454 obj = new OJ454();
        int[] A = new int[]{0, 1, -1};
        int[] B = new int[]{-1, 1, 0};
        int[] C = new int[]{0, 0, 1};
        int[] D = new int[]{-1, 1, 1};
        System.out.println(obj.fourSumCount(A, B, C, D));


    }
}