package practice.leetcode.oj441to450;

/**
 * @author xiaoyue26
 */
public class OJ443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int end = 0, count = 1;
        char pre = chars[0];
        for (int i = 1; i < chars.length; i++) {

            if (pre == chars[i]) {
                count++;
            } else {// store:
                chars[end++] = pre;
                if (count > 1) {
                    String c = String.valueOf(count);
                    for (int j = 0; j < c.length(); j++) {
                        chars[end++] = c.charAt(j);
                    }
                }
                count = 1;
                pre = chars[i];
            }
        }
        // store last:
        chars[end++] = pre;
        if (count > 1) {
            String c = String.valueOf(count);
            for (int j = 0; j < c.length(); j++) {
                chars[end++] = c.charAt(j);
            }
        }

        return end;
    }

    public static void main(String[] args) {
        OJ443 obj = new OJ443();
        System.out.println(obj.compress(new char[]{
                'a', 'a', 'b', 'b', 'c', 'c', 'c'
        }));// 6
        System.out.println(obj.compress(new char[]{
                'a'
        }));// 1
        System.out.println(obj.compress(new char[]{
                'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'
        }));// 4
    }
}
