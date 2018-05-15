package practice.leetcode.oj031to040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/19.
 */
public class OJ039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length < 1) {
            return res;
        }

        Arrays.sort(candidates);

        for (int i = 0; i < candidates.length; i++) {
            if (target == candidates[i]) {
                res.add(Arrays.asList(candidates[i]));
            } else {
                List<List<Integer>> curRes = combinationSum(candidates, target - candidates[i], i);
                for (List<Integer> curRow : curRes) {
                    List<Integer> row = new ArrayList<>();
                    row.add(candidates[i]);
                    row.addAll(curRow);
                    res.add(row);
                }
            }
        }


        return res;
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target, int begin) {//dfs
        List<List<Integer>> res = new ArrayList<>();
        if (target <= 0) {
            return res;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return res;
            }
            if (target == candidates[i]) {
                res.add(Arrays.asList(candidates[i]));
                return res;
            }
            // else target > candidates[i]
            List<List<Integer>> curRes = combinationSum(candidates, target - candidates[i], i);
            for (List<Integer> curRow : curRes) {
                List<Integer> row = new ArrayList<>();
                row.add(candidates[i]);
                row.addAll(curRow);
                res.add(row);
            }
        }


        return res;
    }

    public static void main(String[] args) {
        OJ039 obj = new OJ039();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(obj.combinationSum(candidates, target));
    }
}
