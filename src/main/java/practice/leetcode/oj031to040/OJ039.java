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
        Arrays.sort(candidates);
        dfs(candidates, res, target, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, List<List<Integer>> res, int target, List<Integer> cur, int begin) {
        if (target < 0) {
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            int c = candidates[i];
            if (target == c) {
                List<Integer> r = new ArrayList<>(cur);
                r.add(c);
                res.add(r);
                return;
            } else if (target < c) {
                return;
            } else {
                cur.add(c);
                dfs(candidates, res, target - c, cur, i);
                cur.remove(cur.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        OJ039 obj = new OJ039();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(obj.combinationSum(candidates, target));
    }
}
