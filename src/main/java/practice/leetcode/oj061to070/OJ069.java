package practice.leetcode.oj061to070;

/**
 * Created by xiaoyue26 on 17/12/2.
 * 牛顿迭代法,画个图用tan算一下就好了.
 * 迭代次数不一定非得是10次,起点也随意定就好,可以用精度差距判断,而不用经验参数.
 */
public class OJ069 {
    public int mySqrt(int x) {
        double y = 600.1;
        for(int i = 0; i < 10; ++i)
            y = 0.5 * y + x * 0.5 / y;
        return (int)y;
    }

    public static void main(String[] args) {
        OJ069 obj = new OJ069();
        System.out.println(obj.mySqrt(2));
        System.out.println(obj.mySqrt(4));
        System.out.println(obj.mySqrt(6));
        System.out.println(obj.mySqrt(8));
        System.out.println(obj.mySqrt(10));
    }
}
