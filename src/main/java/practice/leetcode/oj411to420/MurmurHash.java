package practice.leetcode.oj411to420;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 * @author xiaoyue26
 */
public class MurmurHash {

    public void test() {
        HashFunction hf = Hashing.murmur3_128(); // 32bit version available as well
        HashCode hc = hf.newHasher()
                .putString("name", Charsets.UTF_8)
                .putLong(123)
                .hash();
        System.out.println(hc.asLong());
    }

    public static void main(String[] args) {
        MurmurHash obj = new MurmurHash();
        obj.test();
        System.out.println("there");
    }
}
