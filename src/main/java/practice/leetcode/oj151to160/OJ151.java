package practice.leetcode.oj151to160;

/**
 * Created by xiaoyue26 on 18/1/3.
 */
public class OJ151 {
    public String reverseWords(String s) {
        if (s.length() < 1) {
            return "";
        }
        char[] chars = s.toCharArray();
        boolean acceptSpace = false;
        int left = 0, right = -1, top = -1;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (acceptSpace) {
                    // deal last one
                    reverseChars(chars, left, right);
                    // new left
                    chars[++top] = chars[i];
                    acceptSpace = false;
                    left = top + 1;
                    right = top;
                } else {
                    // ignore
                }
            } else {
                chars[++top] = chars[i];
                acceptSpace = true;
                right++;
            }
        }
        // deal last one
        if (acceptSpace) {
            reverseChars(chars, left, right);
        } else {
            top--;
        }
        // reverse [0,top]
        reverseChars(chars, 0, top);
        if (top == -2) {
            return "";
        }
        return new String(chars, 0, top + 1);
    }

    private void reverseChars(char[] chars, int left, int right) {
        if (right > left) {
            int halfLen = (right - left) >> 1;
            char tmp;
            for (int i = 0; i <= halfLen; i++) {
                tmp = chars[left + i];
                chars[left + i] = chars[right - i];
                chars[right - i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        OJ151 obj = new OJ151();
        //System.out.println(obj.reverseWords(" the  sky is blue "));
        System.out.println(obj.reverseWords(" "));
    }
}
