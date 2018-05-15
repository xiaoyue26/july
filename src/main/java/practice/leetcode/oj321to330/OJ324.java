package practice.leetcode.oj321to330;

import practice.leetcode.utils.PrintUtils;

// nums[0] < nums[1] > nums[2] < nums[3]....
public class OJ324 {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;
        // 假设变换前的坐标是index (坐标系1)
        // 变换后的坐标是newIndex（坐标系2）
        // 由于是1对1的变换，可以理解成在另一个坐标系下，完全按照newIndex进行遍历
        // 左边的指针是left, 新坐标系下是newIndex(left)
        // 右边的指针是right,新坐标系下是newIndex(right)
        // 工作的指针是i,    新坐标系下是newIndex(i)
        // 新坐标系下以median作为枢纽元，进行一次partition:
        // 比median大的放到left指针下，left指针++,工作指针i++;
        // 比median小的放到right指针下，right指针--,工作指针不变;
        // 与median相等的则保持不变,留在原地，工作指针i++。
        while (i <= right) {

            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left, n), newIndex(i, n));
                i++;
                left++;
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right, n), newIndex(i, n));
                right--;
            } else {
                i++;
            }
        }


    }
    /*
     * 把0,1,2,3,4,5 映射到 1,3,5,0,2,4
     * */
    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

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
        OJ324 obj = new OJ324();
        int[] nums = new int[]{
                1, 5, 1, 1, 6, 4 // 1, 4, 1, 5, 1, 6
        };
        obj.wiggleSort(nums);
        PrintUtils.print(nums);
        nums = new int[]{
                1, 3, 2, 2, 3, 1// 2, 3, 1, 3, 1, 2
        };
        obj.wiggleSort(nums);
        PrintUtils.print(nums);
    }
}
