package practice.leetcode.oj461to470;

/**
 * @author xiaoyue26
 */
public class OJ461 {
    //  return Integer.bitCount(x ^ y);
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int count = 0;
        while (tmp != 0) {
            tmp &= tmp - 1;
            count += 1;
        }
        return count;

    }

    public static void main(String[] args) {
        OJ461 obj = new OJ461();
        System.out.println(obj.hammingDistance(1, 4));//2
    }
}