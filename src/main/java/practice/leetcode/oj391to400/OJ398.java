package practice.leetcode.oj391to400;

import java.util.*;

/**
 * @author xiaoyue26
 * 数组可能非常长。
 * 额外空间不能用太多。
 */
public class OJ398 {
    // 1. 时间优先的解法:
    private final Map<Integer, List<Integer>> locs = new HashMap<>();
    private final Random random = new Random();

    public OJ398(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> loc = locs.getOrDefault(nums[i], new LinkedList<>());
            loc.add(i);
            locs.put(nums[i], loc);
        }
    }

    public int pick(int target) {
        List<Integer> loc = locs.get(target);
        if (loc != null) {
            // int i = (int) (Math.random() * loc.size()); // 更慢一点
            int i = random.nextInt(loc.size());
            System.out.println(i);
            return loc.get(i);
        }
        return -1;
    }

    // 2. 空间优先的解法:
    int[] nums;
    Random rnd;

    public void Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick_time(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }

        return result;
    }

    // main:
    public static void main(String[] args) {
        OJ398 obj = new OJ398(new int[]{
                1, 2, 3, 3, 3
        });
        System.out.println(obj.pick(3));// 2,3,4
        System.out.println(obj.pick(1));// 0
    }
}
