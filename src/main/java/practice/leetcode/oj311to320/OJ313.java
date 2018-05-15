package practice.leetcode.oj311to320;

public class OJ313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 1) {
            return 1;
        }
        int[] points = new int[primes.length];
        int[] res = new int[n];
        res[0] = 1;
        int index = 1;
        int min;
        while (index < n) {
            min = res[points[0]] * primes[0];
            for (int i = 1; i < primes.length; i++) {
                min = Math.min(min
                        , res[points[i]] * primes[i]
                );
            }
            for (int i = 0; i < primes.length; i++) {
                if (min == res[points[i]] * primes[i]) {
                    points[i]++;
                }
            }
            res[index++] = min;
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        OJ313 obj = new OJ313();
        System.out.println(obj.nthSuperUglyNumber(4, new int[]{
                2, 7, 13, 19
        }));
    }
}