package practice.leetcode.oj061to070;

/**
 * Created by xiaoyue26 on 17/12/1.
 */
public class OJ065 {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        char c;

        boolean numFlag = false;
        boolean opFlag = false;
        boolean eFlag = false;
        boolean pointFlag = false;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numFlag = true;
            } else if (c == '-' || c == '+') {
                if (i > 0 && s.charAt(i - 1) == 'e') {
                    continue;
                }
                if (opFlag || numFlag) {
                    return false;
                }
                opFlag = true;

            } else if (c == 'e') {
                if (eFlag) {
                    return false;
                }
                if (!numFlag) {
                    return false;
                }
                eFlag = true;
                if (s.length() > i + 1) {
                    if(s.charAt(i+1)<'0'||s.charAt(i+1)>'9'){
                        return false;
                    }
                } else {
                    return false;
                }

            } else if (c == '.') {
                if (pointFlag) {
                    return false;
                }
                if (s.length() > i + 1) {
                    if (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                        pointFlag = true;
                    } else {
                        return false;
                    }
                } else {
                    if (!numFlag) {
                        return false;
                    }
                }

            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OJ065 obj = new OJ065();
        System.out.println(obj.isNumber("0"));//true
        System.out.println(obj.isNumber(" 0.1"));//true
        System.out.println(obj.isNumber("abc"));//false
        System.out.println(obj.isNumber("1 a"));//false
        System.out.println(obj.isNumber("2e10"));//true
    }
}
