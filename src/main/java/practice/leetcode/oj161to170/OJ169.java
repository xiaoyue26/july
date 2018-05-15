package practice.leetcode.oj161to170;

/**
 * Created by xiaoyue26 on 18/1/8.
 */
public class OJ169 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int[] major_count = new int[2];
        major_count[0] = nums[0];
        major_count[1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != major_count[0]) {
                if (major_count[1] <= 0) {
                    major_count[0] = nums[i];
                    major_count[1] = 1;
                } else {
                    major_count[1]--;
                }

            } else {
                major_count[1]++;
            }
        }


        return major_count[0];
    }

    public static void main(String[] args) {
        OJ169 obj = new OJ169();
        System.out.println(obj.majorityElement(new int[]{1, 3, 5, 3, 3, 5, 5, 5, 5}));
    }
}
