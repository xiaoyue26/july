package practice.leetcode.oj001to010;

/**
 * Created by xiaoyue26 on 17/11/3.
 */
public class OJ007 {
    public int reverse(int x) {
        int maxthresh=Integer.MAX_VALUE/10,minthresh=Integer.MIN_VALUE/10;
        int result=0;
        while (x!=0) {
            if (result>maxthresh||result<minthresh)
                return 0;
            result*=10;
            result+=x%10;
            x/=10;
        }
        return result;
    }

    public static void main(String[] args) {
        OJ007 obj = new OJ007();
        int res = obj.reverse(-1000000003);
        System.out.println(res);
        System.out.println(Integer.MAX_VALUE/10);
        System.out.println(Integer.MIN_VALUE/10);
        System.out.println((-1)%10);
    }
}
