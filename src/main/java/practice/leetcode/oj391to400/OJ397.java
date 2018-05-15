package practice.leetcode.oj391to400;

/**
 * @author xiaoyue26
 * 变成1的最小次数.
 * 偶数 -> n/2
 * 奇数 -> n+1/n-1
 *
 * 如果加1以后，右侧产生了更多的0，则加1，反之就减1。
 */
public class OJ397 {
    public int integerReplacement(int n) {
        int c = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || ((n >>> 1) & 1) == 0) {// 如果右移以后末尾是1
                --n;
            } else {
                ++n;
            }
            ++c;
        }
        return c;
    }

    public static void main(String[] args) {
        OJ397 obj = new OJ397();
        System.out.println(obj.integerReplacement(8)); // 3: 8,4,2,1
        System.out.println(obj.integerReplacement(7)); // 4: 7,8,4,2,1; 7,6,3,2,1
        System.out.println(obj.integerReplacement(65535)); // 17
    }
}
