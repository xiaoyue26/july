package practice.leetcode.oj491to500;

import java.util.*;

/**
 * @author xiaoyue26
 */
public class OJ491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();// 有深比较能力
        List<Integer> holder = new ArrayList<>();
        dfs(res, holder, 0, nums);
        return new ArrayList<>(res);// set 转 list
    }

    public void dfs(Set<List<Integer>> res, List<Integer> holder, int index, int[] nums) {
        if (holder.size() >= 2) {
            res.add(new ArrayList<>(holder));
        }
        for (int i = index; i < nums.length; i++) {
            if (holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i]) {
                holder.add(nums[i]);
                dfs(res, holder, i + 1, nums);// 从下一个元素开始dfs
                holder.remove(holder.size() - 1);// backtrace: 移除最后一个
            }
        }
    }

    public static void main(String[] args) {
        OJ491 obj = new OJ491();
        System.out.println(obj.findSubsequences(new int[]{
                4, 6, 7, 7
        }));

        // HashSet具备深比较的能力
        Set<List<Integer>> res = new HashSet<>();
        res.add(Arrays.asList(1,4,5));
        res.add(Arrays.asList(1,4,5));
        System.out.println(res);// 1,4,5
    }
}
