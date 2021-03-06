package practice.leetcode.oj411to420;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author xiaoyue26
 */
public class MD5Test {
    public static String md5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        StringBuilder hexString = new StringBuilder();
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(str.getBytes("utf-8"));

        for (byte aHash : hash) {
            if ((0xff & aHash) < 0x10) {
                hexString.append("0").append(Integer.toHexString((0xFF & aHash)));
            } else {
                hexString.append(Integer.toHexString(0xFF & aHash));
            }
        }
        return hexString.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String input = "123-test01";
        String afterMd5 = md5(input);
        String first15 = afterMd5.substring(0, 15);
        Long base16 = Long.valueOf(first15, 16);
        System.out.println(base16 % 100);


        //d850f04cdb48312a9be171e214c0b4ee
        //d850f04cdb48312a9be171e214c0b4ee
    }
}
