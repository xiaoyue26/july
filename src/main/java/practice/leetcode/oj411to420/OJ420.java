package practice.leetcode.oj411to420;

/**
 * @author xiaoyue26
 */
public class OJ420 {
    public int strongPasswordChecker(String s) {
        if (s == null || s.length() == 0) {
            return 6;
        }
        int lenGap;
        if (s.length() >= 6 && s.length() <= 20) {
            lenGap = 0;
        } else if (s.length() < 6) {
            lenGap = s.length() - 6;// <0
        } else {// s.length>20
            lenGap = s.length() - 20;//>0
        }
        char[] chars = s.toCharArray();
        //boolean lower = false, uper = false, digit = false;
        boolean[] flags = new boolean[3];
        char pre = '0';
        int dedupCount = 1;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                flags[0] = true;
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                flags[1] = true;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                flags[2] = true;
            }

            if (i != 0) {//check pre
                if (chars[i] == pre) {
                    dedupCount++;
                    if (dedupCount >= 3) {
                        int[] r = gredyFix(lenGap, flags, chars, i);
                        lenGap = r[0];
                        dedupCount = r[1];
                        res += 1;

                    }
                } else {
                    dedupCount = 1;
                }
            }
            pre = chars[i];
        }
        for (boolean flag : flags) {
            if (!flag) {
                res += 1;
                lenGap = gredyFix2(lenGap);
            }
        }


        res += Math.abs(lenGap);

        return res;
    }

    private int gredyFix2(int lenGap) {
        if (lenGap > 0) {
            return lenGap;
        } else if (lenGap < 0) {
            return lenGap + 1;
        } else { // lenGap==0
            return 0;
        }
    }

    private int[] gredyFix(int lenGap, boolean[] flags, char[] chars, int x) {
        if (lenGap > 0) {
            if (x + 1 <= chars.length - 1 && chars[x + 1] == chars[x]) {
                // try mod:
                for (int i = 0; i < flags.length; i++) {
                    if (!flags[i]) {
                        flags[i] = true;
                        break;
                    }
                }
                return new int[]{lenGap, 0};
            } else { // just delete
                return new int[]{
                        lenGap - 1, 2
                };
            }
        } else if (lenGap < 0) {
            for (int i = 0; i < flags.length; i++) {
                if (!flags[i]) {
                    flags[i] = true;
                    break;
                }
            }
            return new int[]{lenGap + 1, 0};
        } else { // lenGap==0
            for (int i = 0; i < flags.length; i++) {
                if (!flags[i]) {
                    flags[i] = true;
                    break;
                }
            }
            return new int[]{0, 0};
        }
    }

    public static void main(String[] args) {
        OJ420 obj = new OJ420();
        System.out.println(obj.strongPasswordChecker("aabbb"));//2
        System.out.println(obj.strongPasswordChecker("ABABABABABABABABABAB1"));//2
        System.out.println(obj.strongPasswordChecker("aaaabbaaabbaaa123456A"));//3
        System.out.println(obj.strongPasswordChecker("1Abababcaaaabababababa"));//2
    }
}
