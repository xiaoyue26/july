package practice.leetcode.oj001to010;

/**
 * Created by xiaoyue26 on 17/11/4.
 */
public class OJ008 {
    public int myAtoi(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        int cur = 0;
        while (cur < str.length() && str.charAt(cur) == ' ') cur++;// 去头
        int res = 0;
        int resIndex = 0;
        boolean bigThan0 = true;
        for (int i = cur; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                if (res > Integer.MAX_VALUE / 10) {
                    return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE / 10) {
                    return Integer.MIN_VALUE;
                }
                if (bigThan0) {
                    res = res * 10 + c - '0';
                    if (res < 0) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    res = res * 10 + '0' - c;
                    if (res > 0) {
                        return Integer.MIN_VALUE;
                    }
                }
                resIndex++;
            } else if (c == '-') {
                if (resIndex == 0) {
                    bigThan0 = false;
                } else {
                    return res;
                }
                resIndex++;
            } else if (c == '+') {
                if (resIndex == 0) {
                    bigThan0 = true;
                } else {
                    return res;
                }
                resIndex++;
            } else {
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OJ008 obj = new OJ008();
        //String str = "  b1234";
        String str = "  14b";
        System.out.println(obj.myAtoi(str));

        System.out.println(obj.myAtoi(" 42"));// permit head space
        System.out.println(obj.myAtoi("-42"));
        System.out.println(obj.myAtoi("4193 with words")); // 4193
        System.out.println(obj.myAtoi("weords and 987")); // 0
        System.out.println(obj.myAtoi("-91283472332")); // overflow Int.Min
        System.out.println(obj.myAtoi("91283472332")); // overflow Int.Max
        System.out.println(obj.myAtoi(" +42"));// permit head space
        System.out.println(obj.myAtoi(" -2147483647"));
    }
}
