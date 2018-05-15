package practice.leetcode.oj131to140;

/**
 * Created by xiaoyue26 on 17/12/26.
 * 因为题目说只有一个解,因此可以直接求循环数组的最大子序列. 用dp.
 * (因此有点不实际.)
 * diff[i] = gas[i] - cost[i]
 * 走一个点的剩余值. 求diff的最大可能值. >=0就返回开头, <0就不可行返回-1.
 * <p>
 * 定理:
 * 对于一个循环数组，如果这个数组整体和 SUM >= 0，那么必然可以在数组中找到这么一个元素：
 * 从这个数组元素出发，绕数组一圈，能保证累加和一直是处于非负状态。
 */
public class OJ134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int left = 0, total = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];// 试着从i到i+1.
            if (tank < 0) {
                left = i + 1; // 从i出发不可行,改成从i+1
                total += tank;
                tank = 0;
            }
        }
        if (total + tank < 0) {
            return -1;
        } else {
            return left;
        }
    }
    /**
     * 可以转化成不循环数组的最大子序列和最小子序列
     *
     *
     * */
    public int maxSumCycle(int[] arr) {


        return -1;
    }

    public static void main(String[] args) {
        OJ134 obj = new OJ134();
        int[] gas = new int[]{4};
        int[] cost = new int[]{5};
        System.out.println(obj.canCompleteCircuit(gas, cost));

        int[] arr = new int[]{1, -2, 3, 5, -1, 2};
        System.out.println(obj.maxSumCycle(arr));
    }
}
