package practice.leetcode.oj001to010;

/**
 * Created by xiaoyue26 on 17/10/31.
 */
public class OJ004 {
    public double findMedianSortedArrays(int[] num1, int[] num2) {
        if (num1 == null || num1.length == 0) {//这些可以精简归化到单个数组找第k元素中. 但如果可以重用也可以留着.
            return findMedianSortedArrays(num2);
        }
        if (num2 == null || num2.length == 0) {
            return findMedianSortedArrays(num1);
        }
        int len = num1.length + num2.length;
        if (len % 2 == 0) {
            double median1 = find_k_th(num1, 0, num1.length - 1
                    , num2, 0, num2.length - 1, len / 2);
            double median2 = find_k_th(num1, 0, num1.length - 1
                    , num2, 0, num2.length - 1, len / 2 - 1);
            return (median1 + median2) / 2;
        } else {
            return find_k_th(num1, 0, num1.length - 1
                    , num2, 0, num2.length - 1, len / 2);
        }
    }

    private double findMedianSortedArrays(int[] num) {
        if (num == null || num.length == 0) {
            throw new RuntimeException("empty num has no median");
        }
        if (num.length % 2 == 0) {
            return ((double)num[num.length / 2] + (double)num[num.length / 2 - 1]) / 2;
        }
        return num[num.length / 2];
    }


    private double find_k_th(int[] num1, int begin1, int end1, int[] num2, int begin2, int end2, int k) {
        if (end1 - begin1 < 0) {
            return find_k_th(num2, begin2, end2, k);
        }
        if (end2 - begin2 < 0) {
            return find_k_th(num1, begin1, end1, k);

        }
        if (k <= 0) {
            return Math.min(num1[begin1], num2[begin2]);
        }
        // keeep num1 shorter:
        if (end1 - begin1 > end2 - begin2) {
            return find_k_th(num2, begin2, end2, num1, begin1, end1, k);
        }
        int part_all = k + 1;
        int part1 = Math.min(end1 - begin1 + 1, part_all / 2);
        int part2 = part_all - part1;
        int k1 = begin1 + part1 - 1;
        int k2 = begin2 + part2 - 1;
        int m1 = num1[k1];
        int m2 = num2[k2];
        if (m1 < m2) {
            return find_k_th(num1, k1 + 1, end1, num2, begin2, k2, k - part1);
        } else if (m1 > m2) {
            return find_k_th(num1, begin1, k1, num2, k2 + 1, end2, k - part2);
        } else { // m1==m2
            return m1;
        }


    }

    private double find_k_th(int[] num, int begin, int end, int k) {
        if (end - begin < k) {
            throw new RuntimeException("k out of range");
        }
        return num[begin + k];
    }

    public static void main(String[] args) {
        OJ004 obj = new OJ004();
        int num1[] = {};
        int num2[] = {2,3};
        double res = obj.findMedianSortedArrays(num1, num2);
        System.out.println(res);
        //System.out.println(-1 / 2);

    }
}
