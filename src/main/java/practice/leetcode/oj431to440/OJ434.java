package practice.leetcode.oj431to440;

/**
 * @author xiaoyue26
 */
public class OJ434 {
    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        boolean begin = false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (begin) {
                    count += 1;
                    begin = false;
                }
            } else {
                begin = true;
            }
        }
        if (begin) {
            count += 1;
        }

        return count;
    }

    public static void main(String[] args) {
        OJ434 obj = new OJ434();
        System.out.println(obj.countSegments("Hello, my name is John"));
    }
}
