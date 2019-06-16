package practice.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiaoyue26
 */
public class MergeTest {

    private void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length);
    }

    private void mergeSort(int[] nums, int begin, int length) {
        if (length <= 1) {
            return;
        }
        mergeSort(nums, begin, length / 2);
        mergeSort(nums, begin + length / 2, length - length / 2);
        merge(nums, begin, begin + length / 2, length);
    }

    private void merge(int[] nums, int leftBegin, int rightBegin, int length) {
        int leftEnd = rightBegin - 1;
        int rightEnd = leftBegin + length - 1;
        int[] tmp = new int[length];// TODO 可重用
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
        MergeTest obj = new MergeTest();
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
