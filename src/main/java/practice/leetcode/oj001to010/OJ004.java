package practice.leetcode.oj001to010;

/**
 * Created by xiaoyue26 on 17/10/31.
 */
public class OJ004 {
    // @desperated:
    private double findMedianSortedArrays(int[] num) {
        if (num == null || num.length == 0) {
            throw new RuntimeException("empty num has no median");
        }
        if (num.length % 2 == 0) {
            return ((double) num[num.length / 2] + (double) num[num.length / 2 - 1]) / 2;
        }
        return num[num.length / 2];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || (nums1.length == 0 && nums2.length == 0)) {
            return 0;
        }
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {// 偶数: len = 2x, return [f(x)+f(x+1)]/2
            return ((double) findXth(len / 2, nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1)
                    + (double) findXth(len / 2 + 1, nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1)) / 2;
        } else {// 奇数: len=2x+1 return f(x+1)
            return findXth(len / 2 + 1, nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
        }
    }

    // base 1,找第x个数
    private int findXth(int x, int[] nums1, int begin1, int end1, int[] nums2, int begin2, int end2) {
        if (begin1 > end1) {//nums1 empty
            return nums2[begin2 + x - 1];
        }
        if (begin2 > end2) {// nums2 empty
            return nums1[begin1 + x - 1];
        }
        if (x == 1) {
            return Math.min(nums1[begin1], nums2[begin2]);
        }

        int m = end1 - begin1 + 1;
        int n = end2 - begin2 + 1;
        if (x == m + n) {
            return Math.max(nums1[end1], nums2[end2]);
        }

        if (end1 - begin1 > end2 - begin2) {// keep nums1 shorter
            return findXth(x, nums2, begin2, end2, nums1, begin1, end1);
        }
        int part1 = Math.min(end1 - begin1 + 1, x / 2);
        int part2 = x - part1;
        int k1 = begin1 + part1 - 1;
        int k2 = begin2 + part2 - 1;
        if (nums1[k1] < nums2[k2]) {// nums1去头,nums2去尾:
            return findXth(x - part1, nums1, k1 + 1, end1, nums2, begin2, k2);
        } else if (nums1[k1] > nums2[k2]) {// nums1去尾,nums2去头:
            return findXth(x - part2, nums1, begin1, k1, nums2, k2 + 1, end2);
        } else { // nums1[k1]==nums2[k2]
            return nums1[k1];
        }
    }

    public static void main(String[] args) {
        OJ004 obj = new OJ004();
        int num1[] = {};
        int num2[] = {2, 3};
        double res = obj.findMedianSortedArrays(num1, num2);
        System.out.println(res);
        System.out.println(obj.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(obj.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(obj.findMedianSortedArrays(new int[]{}, new int[]{3, 4}));
        System.out.println(obj.findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 1}));
        System.out.println(obj.findMedianSortedArrays(new int[]{2}, new int[]{1, 3, 4}));
        System.out.println(obj.findMedianSortedArrays(new int[]{}, new int[]{}));
        System.out.println(obj.findMedianSortedArrays(new int[]{}, null));
        System.out.println(obj.findMedianSortedArrays(null, null));
        //System.out.println(-1 / 2);

    }
}
