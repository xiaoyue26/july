package practice.leetcode.oj271to280;

import java.util.List;

/**
 * Created by jiuzhoumu on 2018/2/10.
 */
public class OJ273 {
    public static final String[] v3 = new String[]{
            "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        String res = convertHundred(num % 1000);
        for (int i = 0; i < 3; ++i) {
            num /= 1000;
            res = num % 1000 != 0 ? convertHundred(num % 1000) + " " + v3[i] + " " + res : res;
        }
        res = res.trim();
        if (res.length() == 0) {
            return "Zero";
        }
        return res;
    }

    public static final String[] v1 = new String[]{
            "", "One", "Two", "Three", "Four", "Five"
            , "Six", "Seven", "Eight", "Nine", "Ten"
            , "Elevent", "Twelve", "Thirteen", "Fourteen", "Fifteen"
            , "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static final String[] v2 = new String[]{
            "", "", "Twenty", "Thirty", "Forty", "Fifty"
            , "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private String convertHundred(int num) {
        String res;
        int a = num / 100, b = num % 100, c = num % 10;
        if (b < 20) {
            res = v1[b];
        } else {
            res = v2[b / 10] + (c != 0 ? " " + v1[c] : "");
        }
        if (a > 0) {
            res = v1[a] + " Hundred" + (b != 0 ? " " + res : "");
        }

        return res;
    }

    public static void main(String[] args) {
        OJ273 obj = new OJ273();
        System.out.println(obj.numberToWords(123));
    }
}
