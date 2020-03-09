package practice.leetcode.oj041to050;

/**
 * Created by xiaoyue26 on 17/11/20.
 */
public class OJ041_test {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }
        boolean flag[] = new boolean[nums.length];
        for (int n : nums) {
            if (n > 0 && n-1 < nums.length) {
                flag[n - 1] = true;
            }
        }
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]) {
                return i + 1;
            }
        }
        return flag.length + 1;
    }

    public static void main(String[] args) {
        OJ041_test obj = new OJ041_test();
        int nums[] = {1, 2, 0};//3
        int nums2[] = {3, 4, -1, 1};//2
        int nums3[] = {1, 1};//2
        System.out.println(obj.firstMissingPositive(nums));
        System.out.println(obj.firstMissingPositive(nums2));
        System.out.println(obj.firstMissingPositive(nums3));
        System.out.println(obj.firstMissingPositive(new int[]{1}));
    }

}
