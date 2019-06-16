package practice.leetcode;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author xiaoyue26
 */
public class MergeOptFinal {


    // 改写成了尾递归:
    @SuppressWarnings("Duplicates")
    private void mergeSort(int[] nums) {
        int tmp[] = new int[nums.length];
        for (int size = 1; size < nums.length; size *= 2) {
            for (int j = 0; j + size < nums.length; j += size * 2) {
                merge(nums, j, j + size, size * 2, tmp);
            }
        }

    }

    @SuppressWarnings("Duplicates")
    private void merge(int[] nums, int leftBegin, int rightBegin, int length, int tmp[]) {
        int leftEnd = rightBegin - 1;
        int rightEnd = Math.min(leftBegin + length - 1, nums.length - 1);
        length = rightEnd - leftBegin + 1;// 修正长度
        int curIndex = -1;
        while (leftBegin <= leftEnd && rightBegin <= rightEnd) {
            if (nums[leftBegin] < nums[rightBegin]) {
                tmp[++curIndex] = nums[leftBegin];
                leftBegin++;
            } else {
                tmp[++curIndex] = nums[rightBegin];
                rightBegin++;
            }
        }
        while (leftBegin <= leftEnd) {
            tmp[++curIndex] = nums[leftBegin];
            leftBegin++;
        }
        while (rightBegin <= rightEnd) {
            tmp[++curIndex] = nums[rightBegin];
            rightBegin++;
        }
        // numHead = rightEnd-length+1
        for (int i = 0; i < length; i++) {
            nums[rightEnd - length + 1 + i] = tmp[i];
        }
    }


    public static void main(String[] args) {
        MergeOptFinal obj = new MergeOptFinal();
        int[] nums = new int[]{1, 5, 2, 11, 7, 3, 1, 6, 17, 10, 312, 312, 1, 1, 2323, 4, 56, 3, 14, 5543};
        obj.mergeSort(nums);

        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println();
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }

    }


}
