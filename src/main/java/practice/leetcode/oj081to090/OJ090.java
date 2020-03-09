package practice.leetcode.oj081to090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/10.
 */
public class OJ090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int start, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));// 立刻记录
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            tmp.add(nums[i]);
            dfs(nums, i + 1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }

    }

    public static void main(String[] args) {
        OJ090 obj = new OJ090();
        int nums[] = {4,4,4,1,4};
        System.out.println(obj.subsetsWithDup(nums));

    }
}
