package practice.leetcode.oj351to360;

/**
 * @author xiaoyue26
 * <p>
 * [0,10^n)
 */
public class OJ357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }

    public static void main(String[] args) {
        OJ357 obj = new OJ357();
        System.out.println(obj.countNumbersWithUniqueDigits(2));//91: 除了11,22,33,44,55,66,77,88,99都是不重复的。因此100-9
        System.out.println(obj.countNumbersWithUniqueDigits(3));// 739 = 658+81
        System.out.println(obj.countNumbersWithUniqueDigits(1));// 10
    }
}
