package practice.leetcode.oj031to040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by xiaoyue26 on 17/11/19.
 */
public class OJ040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length < 1) {
            return res;
        }

        Arrays.sort(candidates);
        System.out.println(Arrays.stream(candidates).boxed().collect(Collectors.toList()));

        dfs(candidates, target, res, 0, new ArrayList<>());

        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, int begin, List<Integer> tmp) {
        if (target <= 0) {
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target == candidates[i]) {
                tmp.add(target);
                res.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size() - 1);
                return;
            } else if (target < candidates[i]) {
                return;
            } else { // >
                tmp.add(candidates[i]);
                dfs(candidates, target - candidates[i], res, i + 1, tmp);
                tmp.remove(tmp.size() - 1);
                while (i < candidates.length - 1
                        && candidates[i + 1] == candidates[i])
                    ++i;
            }

        }
    }

    public static void main(String[] args) {
        OJ040 obj = new OJ040();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(obj.combinationSum2(candidates, target));
    }
}
