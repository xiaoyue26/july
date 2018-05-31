package practice.leetcode.oj411to420;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @author xiaoyue26
 */
public class GetBucketByMd5 {
    private int getBucketByMd5(String uin) {
        final String Key = "test01";
        long result = 0;
        try {
            String salting = uin + '-' + Key;
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(salting.getBytes("UTF-8"));
            digest[7] = (byte) (digest[7] & (byte) 0xf0);

            for (int i = 0; i < 8; i++) {
                result <<= 8;
                result |= (digest[i] & 0xFF);
            }
            result >>>= 4;
            return (int) (result % 100);
        } catch (NoSuchAlgorithmException e) {
            ;
        } catch (UnsupportedEncodingException e) {
            ;
        } finally {
            return (int) (result % 100);
        }

    }

    public static void main(String[] args) {
        GetBucketByMd5 obj = new GetBucketByMd5();
        System.out.println(obj.getBucketByMd5("123"));

    }
}
