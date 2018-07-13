package practice.leetcode.oj471to480;

public class OJ479 {
    public int largestPalindrome_ans(int n) {
        int[] ans = {9, 987, 123, 597, 677, 1218, 877, 475};
        return ans[n - 1];
    }

    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        long maxNum = (long) Math.pow(10, n) - 1;
        long minNum = (long) Math.pow(10, n - 1);
        long maxProduct = maxNum * maxNum;
        long firstHalf = maxProduct / (long) Math.pow(10, n);

        while (true) {
            long candidate = palindrome(firstHalf--);
            if (candidate > maxProduct) continue;
            // elinminate candidate like 9889,998899. Which generated from original firstHalf but larger than maxProduct
            for (long i = maxNum; i >= minNum; i--) {
                if (candidate / i > maxNum) break;
                if (candidate % i == 0) return (int) (candidate % 1337);
            }
        }
    }

    public long palindrome(long num) {
        String str = num + new StringBuilder().append(num).reverse().toString();
        return Long.parseLong(str);
    }

    public static void main(String[] args) {
        OJ479 obj = new OJ479();
        System.out.println(obj.largestPalindrome(2));//987
        // 99 x 91 = 9009, 9009 % 1337 = 987
        for (int i = 1; i < 9; i++) {
            System.out.println(obj.largestPalindrome(i));
        }

    }
}
