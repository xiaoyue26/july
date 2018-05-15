package practice.leetcode.oj371to380;

/**
 * @author xiaoyue26
 * a^b % 1337
 * 1337的因数
 * 1,7,191,1337
 * <p>
 * (1)
 * 对于正整数N，代表小于等于N的与N互质的数的个数，记作φ(N).
 * // φ(8)=4
 * (2)
 * 如果两个正整数a和n互质，则n的欧拉函数 φ(n) 可以让下面的等式成立：
 * a^φ(n) mod n = 1
 */
public class OJ372 {
    public int superPow(int a, int[] b) {
        if (a % 1337 == 0) return 0;
        int p = 0;
        for (int i : b) p = (p * 10 + i) % 1140;
        if (p == 0) p += 1440;
        return power(a, p, 1337);
    }

    public int power(int a, int n, int mod) {
        a %= mod;
        int ret = 1;
        while (n != 0) {
            if ((n & 1) != 0) ret = ret * a % mod;
            a = a * a % mod;
            n >>= 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        OJ372 obj = new OJ372();
        System.out.println(obj.superPow(2, new int[]{1, 0}));
    }
}
