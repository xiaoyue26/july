package practice.leetcode.oj471to480;

import java.util.Arrays;

/**
 * @author xiaoyue26
 * 尽量把大的火柴棒用掉
 */


public class OJ473 {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int a = sum / 4;
        boolean[] visited = new boolean[nums.length];
        for (int i = nums.length - 1; i >= 0; --i) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int left = a - nums[i];
            if (left > 0) {
                if (canConsist(nums, visited, left)) {
                    continue;
                } else {
                    return false;
                }

            } else if (left < 0) {
                return false;
            }
        }

        return true;
    }

    private boolean canConsist(int[] nums, boolean[] visited, int target) {

        int index = Arrays.binarySearch(nums, target);
        if (index >= 0) {
            if (!visited[index]) {
                visited[index] = true;
                return true;
            } else {
                //check right
                for (int i = index + 1; i < nums.length; i++) {
                    if (nums[i] > nums[index]) {
                        break;
                    }
                    if (!visited[i]) {
                        visited[i] = true;
                        return true;
                    }
                }
                // check left:
                for (int i = index - 1; i >= 0; --i) {
                    if (nums[i] < nums[index]) {
                        break;
                    }
                    if (!visited[i]) {
                        visited[i] = true;
                        return true;
                    }
                }
            }
        }
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] >= target) {
                continue;
            }
            if (!visited[i]) {
                int left = target - nums[i];
                visited[i] = true;
                if (canConsist(nums, visited, left)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        OJ473 obj = new OJ473();
        System.out.println(obj.makesquare(new int[]{
                1, 1, 2, 2, 2
        }));
        System.out.println(obj.makesquare(new int[]{
                3, 3, 3, 3, 4
        }));
        System.out.println(obj.makesquare(new int[]{
                10, 6, 5, 5, 5, 3, 3, 3, 2, 2, 2, 2
        }));
    }
}