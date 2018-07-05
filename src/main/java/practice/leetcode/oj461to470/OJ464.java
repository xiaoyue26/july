package practice.leetcode.oj461to470;

/**
 * @author xiaoyue26
 */

import java.util.HashMap;
import java.util.Map;

public class OJ464 {

    private Map<Integer, Boolean> map;// dp,保存不同状态下的结局
    private boolean[] used;// 最多20位,所以能转化为1个整数

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;

        map = new HashMap<>();
        used = new boolean[maxChoosableInteger + 1];
        return helper(desiredTotal);
    }

    private boolean helper(int desiredTotal) {
        if (desiredTotal <= 0) return false;// 递归出口,对方已经赢了,那我就输了.
        int key = format(used);
        if (!map.containsKey(key)) {
            // try every unchosen number as next step
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true; // dfs 试探
                    // check whether this lead to a win (i.e. the other player lose)
                    if (!helper(desiredTotal - i)) {// dfs
                        // 假设对方处在这个状态,如果对方不能赢,那我就赢了
                        map.put(key, true);
                        used[i] = false;// 回溯
                        return true;
                    }
                    used[i] = false;// 回溯
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }

    // transfer boolean[] to an Integer
    private int format(boolean[] used) {
        int num = 0;
        for (boolean b : used) {
            num <<= 1;
            if (b) num |= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        OJ464 obj = new OJ464();
        System.out.println(obj.canIWin(20, 300));
        System.out.println(obj.canIWin(10, 11));
    }
}