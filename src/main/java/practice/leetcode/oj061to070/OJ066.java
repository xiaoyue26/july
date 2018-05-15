package practice.leetcode.oj061to070;

import practice.leetcode.utils.PrintUtils;

/**
 * Created by xiaoyue26 on 17/12/1.
 */
public class OJ066 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length < 1) {
            return new int[]{0};
        }
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i > 0; --i) {
            if (digits[i] > 9) {
                digits[i - 1] += digits[i] / 10;
                digits[i] %= 10;
            } else {
                break;
            }
        }
        if (digits[0] > 9) {
            int[] res = new int[digits.length + 1];
            res[0] = digits[0] / 10;
            digits[0] %= 10;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        } else {
            return digits;
        }

    }

    public static void main(String[] args) {
        OJ066 obj = new OJ066();
        int[] digits = {
                0
        };
        PrintUtils.print(obj.plusOne(digits));
    }
}
