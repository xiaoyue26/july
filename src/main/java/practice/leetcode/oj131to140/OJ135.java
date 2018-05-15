package practice.leetcode.oj131to140;

/**
 * Created by xiaoyue26 on 17/12/27.
 * 给最少的candy. 保证每个人比更低分的邻居多.
 */
public class OJ135 {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length < 1) {
            return 0;
        }
        int res = 1, pre = 1, cnt = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (cnt > 0) {
                    res += cnt * (cnt + 1) / 2;
                    if (cnt >= pre) {
                        res += cnt - pre + 1;
                    }
                    cnt = 0;
                    pre = 1;
                }
                pre = (ratings[i] == ratings[i - 1]) ? 1 : pre + 1;
                res += pre;
            } else {
                ++cnt;
            }
        }
        if (cnt > 0) {
            res += cnt * (cnt + 1) / 2;
            if (cnt >= pre) {
                res += cnt - pre + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        OJ135 obj = new OJ135();
        int ratings[] = new int[]{1,3,2,1};
        System.out.println(obj.candy(ratings));
    }
}
