package practice.leetcode.oj471to480;

/**
 * @author xiaoyue26
 */
public class OJ476 {
    public int findComplement(int num) {
        boolean[] bits = new boolean[32];
        int top = 0;
        while (num != 0) {
            if ((num & 1) != 0) {
                bits[top] = true;
            }
            top++;
            num /= 2;
        }
        int res = 0;
        int base = 1;
        for (int i = 0; i < top; i++) {
            if (!bits[i]) {
                res |= 1 << (base - 1);
            }
            base++;
        }
        return res;
    }

    public static void main(String[] args) {
        OJ476 obj = new OJ476();
        System.out.println(obj.findComplement(5));
        System.out.println(obj.findComplement(2));
    }
}
