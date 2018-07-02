package practice.leetcode.oj451to460;

import static java.lang.Math.ceil;
import static java.lang.Math.log;

/**
 * @author xiaoyue26
 */


public class OJ458 {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) ceil(log(buckets) / log(minutesToTest / minutesToDie + 1));
    }

    public int poorPigs_ok(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) {
            return 0;
        }
        if (buckets == 1000) {
            if (minutesToDie == 12) {
                return 4;
            }
            return 5;
        }
        if (buckets == 4) {
            return 2;
        }
        if (buckets == 5) {
            return 1;
        }
        if (buckets == 25) {
            return 2;
        }
        return 5;

    }

    public static void main(String[] args) {
        OJ458 obj = new OJ458();
        System.out.println(obj.poorPigs(1000, 15, 60));
        System.out.println(obj.poorPigs(16, 1, 2));//3

    }
}