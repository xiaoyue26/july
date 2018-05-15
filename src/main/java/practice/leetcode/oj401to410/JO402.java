package practice.leetcode.oj401to410;


/**
 * @author xiaoyue26
 */
public class JO402 {

    public String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            stack[top++] = c;
        }
        int idx = 0;
        while (idx < digits && stack[idx] == '0') idx++;
        return idx == digits ? "0" : new String(stack, idx, digits - idx);
    }

    public static void main(String[] args) {
        JO402 obj = new JO402();
        System.out.println(obj.removeKdigits("1432219", 3));// 1219
        System.out.println(obj.removeKdigits("10200", 1));// 200
        System.out.println(obj.removeKdigits("10", 2));// 0
        System.out.println(obj.removeKdigits("112", 1));// 11
    }
}
