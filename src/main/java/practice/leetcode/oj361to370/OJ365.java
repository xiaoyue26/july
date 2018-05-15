package practice.leetcode.oj361to370;

/**
 * @author xiaoyue26
 * 通用的解法
 * ax+by=z
 * 比如a>0,b<0的话，就是装a次x,倒掉b次y即可。
 */
public class OJ365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z) return true;
        // ax + by = z
        return z % GCD(x, y) == 0;
    }

    public int GCD(int a, int b) {// 把x和y辗转相减,能得到的最小的数
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        OJ365 obj = new OJ365();
        System.out.println(obj.canMeasureWater(3, 5, 4));// True 5-3=2, 3-2=1, 3+1=4
        System.out.println(obj.canMeasureWater(2, 6, 5));// False
        System.out.println(obj.canMeasureWater(8, 9, 7));// True  // -7*8 + -7*9 = 7 // 倒掉7次8，装7次9 就好了

    }
}
