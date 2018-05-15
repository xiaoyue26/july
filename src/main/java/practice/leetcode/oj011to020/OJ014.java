package practice.leetcode.oj011to020;

/**
 * Created by xiaoyue26 on 17/11/5.
 */
public class OJ014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int len = strs[0].length();
        for (String str : strs) {
            len = Math.min(str.length(), len);
        }

        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        OJ014 obj = new OJ014();
        String[] strs = {"abb", "abc", "abx"};
        System.out.println(obj.longestCommonPrefix(strs));
    }
}
