package practice.leetcode.oj071to080;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/5.
 */
public class OJ078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        dfs(nums, 0, nums.length - 1, row, res);
        return res;
    }

    private void dfs(int[] nums, int start, int end
            , List<Integer> row, List<List<Integer>> res) {
        res.add(new ArrayList<>(row)); // 立刻记录
        for (int i = start; i <= end; i++) {
            row.add(nums[i]);
            dfs(nums, i + 1, end, row, res);
            row.remove(row.size() - 1);
        }

    }

    public static void main(String[] args) {
        OJ078 obj = new OJ078();
        int[] nums = {1, 2, 3};
        System.out.println(obj.subsets(nums));
        System.out.println(obj.subsets(new int []{}));
    }
}
