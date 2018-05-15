package practice.leetcode.oj391to400;

/**
 * @author xiaoyue26
 */
public class OJ396 {
    public int maxRotateFunction(int[] A) {
        int allSum = 0;
        int len = A.length;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += i * A[i];
            allSum += A[i];
        }
        int max = F;
        for (int i = len - 1; i >= 1; i--) {
            F = F + allSum - len * A[i];
            max = Math.max(F, max);
        }
        return max;
    }

    public static void main(String[] args) {
        OJ396 obj = new OJ396();
        System.out.println(obj.maxRotateFunction(new int[]{
                4, 3, 2, 6
        }));//max(25,16,23,26) => 26
    }
}
