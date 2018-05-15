package practice.leetcode.oj171to180;

/**
 * Created by xiaoyue26 on 18/1/9.
 */
public class OJ172 {
    public int trailingZeroes(int n) {
        int res=0;
        while(n>0){
            res += n/5;
            n/=5;
        }
        return res;
    }

    public static void main(String[] args) {
        OJ172 obj = new OJ172();
        System.out.println(obj.trailingZeroes(10));
    }
}
