package practice.leetcode.oj461to470;

/**
 * @author xiaoyue26
 */

public class OJ468 {
    public static final String Neither = "Neither";
    public static final String IPv4 = "IPv4";
    public static final String IPv6 = "IPv6";

    public String validIPAddress(String IP) {
        if (IP == null || IP.length() < 4) {
            return Neither;
        }
        if (IP.indexOf(".") > 0) {
            if (validIPv4(IP)) {
                return IPv4;
            } else {
                return Neither;
            }
        } else if (IP.indexOf(":") > 0) {
            if (validIPv6(IP)) {
                return IPv6;
            } else {
                return Neither;
            }
        } else {
            return Neither;
        }
    }

    private boolean validIPv6(String ip) {
        if (ip.endsWith(":")) {
            return false;
        }
        String[] strs = ip.split(":");
        if (strs.length != 8) {
            return false;
        }
        for (String str : strs) {
            if (str.length() > 4 || str.length() == 0) {
                return false;
            }
            char[] cs = str.toCharArray();
            for (char c : cs) {
                if (c >= '0' && c <= '9'
                        ||c >= 'a' && c <= 'f'
                        ||c >= 'A' && c <= 'F') { // pass
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    private boolean validIPv4(String ip) {
        if (ip.endsWith(".")) {
            return false;
        }
        String[] strs = ip.split("\\.");
        if (strs.length != 4) {
            return false;
        }
        for (String str : strs) {
            int i;
            try {
                i = Integer.valueOf(str);
            } catch (Exception e) {
                return false;
            }
            if (i >= 0 && i <= 255) {
                if (str.startsWith("0") && i != 0) {
                    return false;
                }
                if (i == 0 && !str.equals("0")) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        OJ468 obj = new OJ468();
        System.out.println(obj.validIPAddress("172.16.254.1"));//IPv4
        System.out.println(obj.validIPAddress("172.16.254.01"));//Neither
        // IPv6:
        System.out.println(obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        // Neither:
        System.out.println(obj.validIPAddress("256.256.256.256"));
        // Neither:
        System.out.println(obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        // Neither: G字母
        System.out.println(obj.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
        // Neither:
        System.out.println(obj.validIPAddress("20EE:FGb8:85a3::0:8A2E:0370:7334"));

    }
}

