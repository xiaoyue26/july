package practice.leetcode.oj001to010;

/**
 * Created by xiaoyue26 on 17/10/30.
 */
public class OJ004_old {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result;
        int length = nums1.length + nums2.length;

        if (length % 2 == 1) {
            result = find_k_th(nums1, nums2, (length - 1) / 2);
        } else {
            result = (find_k_th(nums1, nums2, (length - 1) / 2) + find_k_th(nums1,
                    nums2, (length - 1) / 2 + 1)) / 2;
        }
        return result;
    }

    public double find_k_th(int[] nums1, int[] nums2, int k) {// k_indicate_the_index_of_whole_array
        return find_k_th(nums1, 0, nums1.length - 1, nums2, 0,
                nums2.length - 1, k);
    }

    private double find_k_th(int[] nums1, int begin1, int end1, int[] nums2,
                             int begin2, int end2, int k) {
        if ((end1 - begin1) > (end2 - begin2))// keep nums2 bigger
            return find_k_th(nums2, begin2, end2, nums1, begin1, end1, k);
        if (end1 < begin1) {// nums1_is_empty
            return nums2[begin2 + k];
        }
        if (k <= 0) {// find_min
            return Math.min(nums1[begin1], nums2[begin2]);
        }
        // end_of_border_handle
        // divide k+1 into two parts
        int part1 = Math.min(end1 - begin1 + 1, (k + 1) / 2);
        int pos1 = begin1 + part1 - 1;
        int part2 = k + 1 - part1;
        int pos2 = begin2 + part2 - 1;
        if (nums1[pos1] < nums2[pos2])
            return find_k_th(nums1, pos1 + 1, end1, nums2, begin2, end2, k
                    - part1);
        else if (nums1[pos1] > nums2[pos2])
            return find_k_th(nums1, begin1, end1, nums2, pos2 + 1, end2, k
                    - part2);
        else
            return nums1[pos1];
    }

    public static void main(String[] args) {
        OJ004_old oj = new OJ004_old();
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        double res = oj.findMedianSortedArrays(num1, num2);
        System.out.println(res);

    }
}
