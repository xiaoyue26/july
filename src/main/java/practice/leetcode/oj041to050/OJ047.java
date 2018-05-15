package practice.leetcode.oj041to050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/23.
 */
public class OJ047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(res, nums, new ArrayList<>(), used);

        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmpList, boolean[] used) {
        if (tmpList.size() == nums.length) {
            res.add(new ArrayList<>(tmpList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] // 跳过情况1:已经用过的元素
                        || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    // 跳过情况2: 前一个元素没有用,而且和当前元素相等.如果使用nums[i],则后续dfs的结果会和dfs(nums[i-1]的结果一样.
                    continue;
                }
                tmpList.add(nums[i]);
                used[i] = true;
                dfs(res, nums, tmpList, used);
                used[i] = false;
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        OJ047 obj = new OJ047();
        int nums[] = {1, 1, 1, 2};
        List<List<Integer>> res = obj.permuteUnique(nums);
        System.out.println(res);
        System.out.println(res.size());
    }
}
