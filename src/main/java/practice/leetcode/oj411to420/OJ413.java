package practice.leetcode.oj411to420;

/**
 * @author xiaoyue26
 */
public class OJ413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int i = 2, count = 2, res = 0;
        while (i < A.length) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                count++;
            } else {
                if (count >= 3) {
                    res += (count - 2) * (count - 1) / 2;
                }
                count = 2;
            }
            i++;
        }
        if (count >= 3) {
            res += (count - 2) * (count - 1) / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        OJ413 obj = new OJ413();
        System.out.println(obj.numberOfArithmeticSlices(new int[]{
                1, 2, 3, 4
        }));//3
        System.out.println(obj.numberOfArithmeticSlices(new int[]{
                1, 2, 3, 4
        }));//3
    }
}
