package practice.leetcode.oj211to220;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyue26 on 18/1/24.
 * 1-9选k个加起来等于n
 */
public class OJ216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        dfs(n, res, 1, tmp, k);
        return res;
    }

    private void dfs(int target, List<List<Integer>> res, int begin, List<Integer> tmp, int k) {
        if (target <= 0 || k <= 0) {
            return;
        }
        for (int i = begin; i <= 9; i++) {
            if (target == i && k == 1) {
                tmp.add(target);
                res.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size() - 1);
                return;
            } else if (target < i) {
                return;
            } else { // >
                tmp.add(i);
                dfs(target - i, res, i + 1, tmp, k - 1);
                tmp.remove(tmp.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        OJ216 obj = new OJ216();
        System.out.println(obj.combinationSum3(3, 7));//[[1,2,4]]
        System.out.println(obj.combinationSum3(3, 9));//[[1,2,6], [1,3,5], [2,3,4]]// 没有3,3,3


    }
}
