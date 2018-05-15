package practice.leetcode.oj391to400;

/**
 * @author xiaoyue26
 * most significant 最高两位
 * 输入data虽然是整型,但这例中,请忽略高位的24位,只取最低8位.
 * UTF-8格式:
 * 每个字符可能是1B~4B:
 * 1B的字符: 以0开头的8位;
 * 2B的字符: 以110开头的8位,再加上以10开头的8位;
 * ...(依次类推)
 * 4B的字符: 以11110开头的8位,再加上三个以10开头的8位.
 */
public class OJ393 {
    /**
     * 每个8位:
     * 0开头: <128
     * 10开头: >=128 && <192
     * 110开头: >=192 && < 224
     * 1110开头: >=224 && < 240
     * 11110开头: >=240 && < 248
     */
    public boolean validUtf8(int[] data) {
        int need10 = 0;
        int mask = 0x000000FF;
        for (int i = 0; i < data.length; ++i) {
            data[i] &= mask;
            if (need10 > 0) {
                if (data[i] >= 128 && data[i] < 192) {
                    need10--;
                } else {
                    return false;
                }
            } else if (data[i] < 128) {
                continue;
            } else if (data[i] >= 128 && data[i] < 192) {
                return false;
            } else if (data[i] >= 192 && data[i] < 224) {
                need10 = 1;
            } else if (data[i] >= 224 && data[i] < 240) {
                need10 = 2;
            } else if (data[i] >= 240 && data[i] < 248) {
                need10 = 3;
            } else if (data[i] >= 248) {
                return false;
            } else {
                return false;
            }
        }
        return need10 == 0;
    }

    public static void main(String[] args) {
        OJ393 obj = new OJ393();
        System.out.println(obj.validUtf8(new int[]{
                197, 130, 1
        }));// 11000101 10000010 00000001 // true
        System.out.println(obj.validUtf8(new int[]{
                235, 140, 4
        }));// 11101011 10001100 00000100 // false
        System.out.println(obj.validUtf8(new int[]{
                255
        }));// 11111111 // false
        System.out.println(obj.validUtf8(new int[]{
                145
        }));//   //false
    }
}
