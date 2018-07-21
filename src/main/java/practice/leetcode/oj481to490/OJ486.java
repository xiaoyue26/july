package practice.leetcode.oj481to490;

/**
 * @author xiaoyue26
 */
// dfs + back_track
public class OJ486 {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length <= 2) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return canWin(nums, 0, nums.length - 1, 0, 0, sum);
    }

    private boolean canWin(int[] nums, int left, int right
            , int mySum, int youSum, int sum) {
        if (mySum > sum - mySum) {
            return true;
        }
        if (left == right) {
            mySum += nums[left];
            return mySum > sum - mySum;
        }
        // go left:
        mySum = mySum + nums[left];
        if (mySum > sum - mySum) {
            return true;
        }

        // check:
        if (!canWin(nums, left + 1, right, youSum, mySum, sum)) {
            return true;
        }
        mySum -= nums[left];
        // go right:
        mySum += nums[right];
        if (mySum > sum - mySum) {
            return true;
        }
        if (!canWin(nums, left, right - 1, youSum, mySum, sum)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        OJ486 obj = new OJ486();
        System.out.println(obj.PredictTheWinner(new int[]{
                1, 5, 2
        }));// false
        System.out.println(obj.PredictTheWinner(new int[]{
                1, 5, 233, 7
        }));// true
        System.out.println(obj.PredictTheWinner(new int[]{
                2, 4, 55, 6, 8
        }));// false
        //
        System.out.println(obj.PredictTheWinner(new int[]{
                0, 0, 7, 6, 5, 6, 1
        }));// false
        System.out.println(obj.PredictTheWinner(new int[]{
                1, 1, 1
        }));// false

    }
}