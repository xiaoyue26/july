package practice.leetcode.oj031to040;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/11/19.
 */
public class OJ040_test {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, target, res, new ArrayList<>(), 0, new HashSet<>());
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> tmp, int begin, Set<Integer> visited) {

        for (int i = begin; i < candidates.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            int c = candidates[i];
            if (target == c) {
                List<Integer> r = new ArrayList<>(tmp);
                r.add(c);
                res.add(r);
                return;
            } else if (c < target) {
                tmp.add(c);
                visited.add(i);
                dfs(candidates, target - c, res, tmp, i, visited);
                tmp.remove(tmp.size() - 1);
                visited.remove(i);
                while (i < candidates.length - 1
                        && candidates[i + 1] == candidates[i])
                    ++i;
            } else {
                return;
            }


        }


    }


    public static void main(String[] args) {
        OJ040_test obj = new OJ040_test();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(obj.combinationSum2(candidates, target));
    }
}
