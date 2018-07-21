package practice.leetcode.oj481to490;

/**
 * @author xiaoyue26
 */
public class OJ485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int num : nums) {
            if (num == 1) {
                cur++;
            } else {
                max = Math.max(max, cur);
                cur = 0;
            }
        }
        max = Math.max(max, cur);
        return max;
    }

    public static void main(String[] args) {
        OJ485 obj = new OJ485();
        System.out.println(obj.findMaxConsecutiveOnes(new int[]{
                1, 1, 0, 1, 1, 1
        }));
    }
}
