package practice.leetcode.oj321to330;

/*
 * 设已经使用的数字集合为patches;
 * 每次把已经纳入patches能达到的范围设为[1,curLen];
 * curEnd: 下一个试探的位置. (其实可以优化掉)
 *
 * 注意事项：
 * (1)数组越界;
 * (2)超出int范围(用long或者手动进行检查)
 * */
public class OJ330 {
    public int minPatches(int[] nums, int n) {
        int res = 0;
        int curLen = 0;
        int curEnd = 1;
        int i = 0;
        while (curEnd <= n) {
            if (i < nums.length && nums[i] <= curEnd) {
                // 把nums[i]纳入curLen,推动curEnd
                curLen += nums[i];
                curEnd = curLen + 1;
                ++i;
            } else {
                res++;// 把curEnd加入patches
                curLen += curEnd;
                curEnd = curLen + 1;
            }
            if (curLen < 0 || curEnd < 0) {
                break;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        OJ330 obj = new OJ330();
        System.out.println(obj.minPatches(new int[]{
                1, 3
        }, 6));//1
        System.out.println(obj.minPatches(new int[]{
                1, 5, 10
        }, 20));//2
        System.out.println(obj.minPatches(new int[]{
                1, 2, 2
        }, 5));//0
        System.out.println(obj.minPatches(new int[]{
        }, 8));//4
        System.out.println(obj.minPatches(new int[]{
                1, 2, 31, 33
        }, 2147483647));//4
    }
}