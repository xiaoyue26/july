package practice.leetcode.oj201to210;

/**
 * Created by xiaoyue26 on 18/1/17.
 */
public class OJ204 {
    public int countPrimes(int n) {
        boolean notPrimes[] = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                ++count;
            }
            for (int j = 2; i * j < n; ++j) {
                notPrimes[i * j] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        OJ204 obj = new OJ204();
        System.out.println(obj.countPrimes(26));
    }
}
