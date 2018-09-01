package practice.leetcode.oj461to470;

import java.util.Random;

/**
 * @author xiaoyue26
 */
public class OJ470 {
    private Random random = new Random();

    private int rand7() {
        return random.nextInt(7) + 1;
    }

    public int rand10() { // solution 1: 7*7=49
        int row, col, res;
        while (true) {
            row = rand7();
            col = rand7();
            res = col + (row - 1) * 7;
            if (res <= 40) {
                return res % 10 == 0 ? 10 : res % 10;
            }
        }
    }

    public int rand10_deep() { // solution 2: 7*7=49 9+()
        int row, col, res;
        while (true) {
            row = rand7();
            col = rand7();
            res = col + (row - 1) * 7;
            if (res <= 40) {
                return res % 10 == 0 ? 10 : res % 10;
            }
            row = rand7(); // 1-7
            col = res - 40; // 1-9
            res = col + (row - 1) * 7; // 1-51
            if(res<=51){
                return res % 10 == 0 ? 10 : res % 10;
            }
        }
    }

    public static void main(String[] args) {
        OJ470 obj = new OJ470();
        System.out.println(obj.rand10());

    }
}
