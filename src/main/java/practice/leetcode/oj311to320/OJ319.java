package practice.leetcode.oj311to320;

/**
 * // n个按钮,按n次后，亮几个
 * 初始全部灯泡off，编号1-n。
 * 1: 打开%1=0的
 * 2: 按 %2=0的
 * 3：按 %3=0的
 * ...
 * n: 按%n=0的。
 */
public class OJ319 {
    public int bulbSwitch_my(int n) { // 1ms
        if (n <= 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int count = 1;
        for (int i = 2; i < n; i++) {
            if (n >= i * i) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }



    public static void main(String[] args) {
        OJ319 obj = new OJ319();
        System.out.println(obj.bulbSwitch(3));// 1
        System.out.println(obj.bulbSwitch(4));// 2
        System.out.println(obj.bulbSwitch(16));// 4
    }

    public int bulbSwitch(int n) { //0ms，再优化一下就变成discuss里的解法了..可惜没意识到T_T..
        return (int) Math.sqrt(n);
    }
}