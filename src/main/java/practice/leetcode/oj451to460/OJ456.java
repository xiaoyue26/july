package practice.leetcode.oj451to460;

/**
 * @author xiaoyue26
 */
public class OJ456 {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(nums[i], min[i - 1]);
        }
        int stack[] = new int[nums.length];
        int top = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] <= min[i]) {// 已经最小,不能作为second
                continue;
            }
            while (top > 0 && stack[top - 1] <= min[i]) {// 清理无效second
                --top;
            }
            if (top > 0 && nums[i] > stack[top - 1]) {// 找到了最大值
                return true;
            }
            stack[top++] = nums[i];
        }

        return false;
    }

    public static void main(String[] args) {
        OJ456 obj = new OJ456();
        System.out.println(obj.find132pattern(new int[]{
                3, 1, 4, 2
        }));
    }
}
