package practice.leetcode.oj211to220;

/**
 * Created by xiaoyue26 on 18/1/23.
 */
public class OJ215 {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    private int findKthLargest(int[] nums, int left, int right, int k) {
        int priot = left;
        int partition_index = partition(nums, left, right, priot);
        if (partition_index == k) {
            return nums[k];
        }
        if (partition_index < k) {
            return findKthLargest(nums, partition_index + 1, right, k);
        } else {// (partition_index > k) {
            return findKthLargest(nums, left, partition_index - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right, int priot) {
        swap(nums, left, priot);
        int i = left;// >= nums[priot]的tail
        for (int j = left + 1; j <= right; j++) {
            if (nums[j] >= nums[left]) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, i);// 把枢纽元换回去
        return i;
    }

    private void swap(int[] nums, int x, int y) {
        if (x != y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
    }


    public static void main(String[] args) {
        OJ215 obj = new OJ215();
        System.out.println(obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));//5
    }
}
