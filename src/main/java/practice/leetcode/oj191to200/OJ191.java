package practice.leetcode.oj191to200;

/**
 * Created by xiaoyue26 on 18/1/14.
 */
public class OJ191 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += 1;
            n &= (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        OJ191 obj = new OJ191();
        System.out.println(obj.hammingWeight(11));
    }
}
