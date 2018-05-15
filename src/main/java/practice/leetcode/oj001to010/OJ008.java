package practice.leetcode.oj001to010;

/**
 * Created by xiaoyue26 on 17/11/4.
 */
public class OJ008 {
    public int myAtoi(String str) {
        if (str == null)
            return 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        int result = 0;
        boolean beginDigit = false;
        boolean hasFlag = false;
        boolean flag = true;
        boolean overflow = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '-' || c == '+') {
                if (beginDigit) {
                    return 0;
                }
                if (hasFlag) {
                    return 0;
                }
                hasFlag = true;
                if (c == '-') {
                    flag = false;
                }
            } else if (Character.isDigit(c)) {
                beginDigit = true;
                if (result > max) {
                    overflow = true;
                }
                result *= 10;
                result += c - '0';
                if (result < 0) {
                    overflow = true;
                }
            }
            else if(c==' '||c=='\t'){
                if(beginDigit){
                    break;
                }
                if(hasFlag){
                    return 0;
                }
                else{
                    continue;
                }
            }else if(beginDigit||hasFlag){
                break;
            }
            else{
                return 0;
            }
        }
        if (!flag) {
            result = -result;
        }
        if (overflow) {
            if (flag) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OJ008 obj = new OJ008();
        //String str = "  b1234";
        String str = "  14b";
        System.out.println(obj.myAtoi(str));
    }
}
