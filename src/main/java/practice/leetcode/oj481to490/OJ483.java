package practice.leetcode.oj481to490;

import java.math.BigInteger;

/**
 * @author xiaoyue26
 */
public class OJ483 {
    public String smallestGoodBase(String nn) {
        long n = Long.parseLong(nn);
        long res = 0;
        for (int k = 60; k >= 2; k--) {
            long begin = 2, end = n;
            //n = 1 + x^1+...x^k = (x^k-1)/(x-1) 等比数列求和公式
            while (begin < end) {
                long mid = begin + (end - begin) / 2;

                BigInteger left = BigInteger.valueOf(mid);
                // x^k-1:
                left = left.pow(k).subtract(BigInteger.ONE);
                // n*(x-1)
                BigInteger right = BigInteger.valueOf(n).multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));
                int cmr = left.compareTo(right);
                if (cmr == 0) {
                    res = mid;
                    break;
                } else if (cmr < 0) {// x^k-1<n*(x-1)=> x太小=> go right
                    begin = mid + 1;
                } else {// x^k-1>n*(x-1)=> x太大=> go left
                    end = mid;
                }
            }

            if (res != 0) break;
        }

        return "" + res;
    }

    public static void main(String[] args) {
        OJ483 obj = new OJ483();
        System.out.println(obj.smallestGoodBase("13"));//3
        System.out.println(obj.smallestGoodBase("4681"));//8
        System.out.println(obj.smallestGoodBase("1000000000000000000"));
        // 999999999999999999

    }
}