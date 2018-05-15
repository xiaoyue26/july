package practice.leetcode.oj341to350;

/**
 * @author xiaoyue26
 */
public class OJ344 {
    public String reverseString_my(String s) {
        if (s == null) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; --i) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String reverseString(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        char tmp;
        while (i < j) {
            tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            ++i;
            --j;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        OJ344 obj = new OJ344();
        System.out.println(obj.reverseString("hello"));// olleh
    }
}
