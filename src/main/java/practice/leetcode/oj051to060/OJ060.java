package practice.leetcode.oj051to060;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/29.
 */
public class OJ060 {


    public String getPermutation(int n, int k) {
        if (n < 1 || k < 1) {
            return "";
        }
        int len = 1;
        StringBuilder res = new StringBuilder();
        List<Character> nums = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            len *= i;
            nums.add((char) ('0' + i));
        }
        k -= 1;
        k %= len;
        len /= n;
        int i = n - 1;
        while (!nums.isEmpty()) {
            int index = k / len;
            res.append(nums.remove(index));
            k %= len;
            if (i > 0) {
                len /= i;
                i -= 1;
            }
        }


        return res.toString();
    }

    public static void main(String[] args) {
        OJ060 obj = new OJ060();
        System.out.println(obj.getPermutation(3, 5));//312
        System.out.println(obj.getPermutation(3, 6));//321
        System.out.println(obj.getPermutation(4, 1));//1234
        System.out.println(obj.getPermutation(4, 24));//4321
    }
}
