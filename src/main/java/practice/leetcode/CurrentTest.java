package practice.leetcode;


/**
 * @author xiaoyue26
 */
public class CurrentTest {
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        int maxn = s.length();
        StringBuilder result = new StringBuilder();
        int interval[] = new int[numRows];
        for (int i = 0; i < interval.length - 1; i++) {
            interval[i] = 2 * (numRows - i - 1);
        }
        interval[interval.length - 1] = 2 * (numRows - 1);

        int index;
        int index2;
        for (int i = 0; i < numRows; i++) {
            index = i;
            index2 = i + interval[i];
            while (index < maxn) {
                char c = s.charAt(index);
                result.append(c);
                index += 2 * (numRows - 1);
                if (i != 0 && i != numRows - 1) {
                    if (index2 < maxn) {
                        c = s.charAt(index2);
                        result.append(c);
                        index2 += 2 * (numRows - 1);
                    }
                }
            }

        }

        return result.toString();
    }


    public static void main(String[] args) {
        CurrentTest obj = new CurrentTest();
        System.out.println(obj.convert("PAYPALISHIRING", 3));// PAHNAPLSIIGYIR
        System.out.println(obj.convert("PAYPALISHIRING", 4));// PINALSIGYAHRPI

    }
}
