package practice.leetcode.oj251to260;

/**
 * Created by xiaoyue26 on 18/2/8.
 */
public class OJ258 {
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {
        OJ258 obj = new OJ258();
        System.out.println(obj.addDigits(38));
    }
}
