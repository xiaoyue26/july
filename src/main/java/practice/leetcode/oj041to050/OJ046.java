package practice.leetcode.oj041to050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/22.
 */
public class OJ046 {
    private int factors(int n) {
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

    private List<List<Integer>> addInteger(List<Integer> pre, Integer num) {
        List<List<Integer>> after = new ArrayList<>(pre.size() + 1);
        for (int i = 0; i <= pre.size(); i++) {
            List<Integer> row = new ArrayList<>(pre.size() + 1);
            row.addAll(pre);
            row.add(i, num);
            after.add(row);
        }
        return after;
    }

    public List<List<Integer>> permute_dp(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        int len = factors(nums.length);
        List<List<Integer>> dp0 = new ArrayList<>(len);
        List<List<Integer>> dp1 = new ArrayList<>(len);
        List<List<Integer>> tmp;
        dp0.add(new ArrayList<>(Arrays.asList(nums[0])));

        for (int i = 1; i < nums.length; i++) {
            for (List<Integer> pre : dp0) {
                List<List<Integer>> after = addInteger(pre, nums[i]);
                dp1.addAll(after);
            }
            tmp = dp0;
            dp0 = dp1;
            dp1 = tmp;
            dp1.clear();
        }


        return dp0;
    }

    public List<List<Integer>> permute(int[] nums) {//dfs + backtrack
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> tmpList) {
        if (tmpList.size() == nums.length) {
            res.add(new ArrayList<>(tmpList));
        } else {
            for (int num : nums) {
                if (!tmpList.contains(num)) {
                    tmpList.add(num);
                    dfs(nums, res, tmpList);
                    tmpList.remove(tmpList.size() - 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        OJ046 obj = new OJ046();
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> res = obj.permute(nums);
        System.out.println(res.size());
        System.out.println(res);
    }
}
