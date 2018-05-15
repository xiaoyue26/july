package practice.leetcode.oj161to170;

/**
 * Created by xiaoyue26 on 18/1/6.
 */
public class OJ165 {
    public int compareVersion(String vA, String vB) {
        if (vA.equals(vB)) {
            return 0;
        }
        String[] wa = vA.split("\\.");
        String[] wb = vB.split("\\.");
        for (int i = 0; i < wa.length || i < wb.length; i++) {
            int a = 0;
            if (i < wa.length) {
                a = Integer.valueOf(wa[i]);
            }
            int b = 0;
            if (i < wb.length) {
                b = Integer.valueOf(wb[i]);
            }
            if (a != b) {
                return Integer.compare(a, b);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        OJ165 obj = new OJ165();
        System.out.println(obj.compareVersion("0.1", "1.1"));
        System.out.println(obj.compareVersion("0", "1"));
        System.out.println(obj.compareVersion("1", "1.1"));
        System.out.println(obj.compareVersion("1", "1.0.0"));// 0
        System.out.println(obj.compareVersion("1", "1.0.1"));// -1
    }
}
