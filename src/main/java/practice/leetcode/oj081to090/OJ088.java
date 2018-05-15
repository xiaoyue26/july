package practice.leetcode.oj081to090;

import practice.leetcode.utils.PrintUtils;

/**
 * Created by xiaoyue26 on 17/12/9.
 */
public class OJ088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int bigHead = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[bigHead--] = nums1[i--];
            } else {
                nums1[bigHead--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[bigHead--] = nums2[j--];
        }

    }

    public static void main(String[] args) {
        OJ088 obj = new OJ088();
        int nums1[] = {2, 4, 6, 0, 0, 0};
        int nums2[] = {1, 2, 5};
        obj.merge(nums1, 3, nums2, 3);
        PrintUtils.print(nums1);
    }
}
