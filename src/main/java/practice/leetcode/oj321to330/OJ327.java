package practice.leetcode.oj321to330;

/*
 *arraycopy(Object src,  int  srcPos,
            Object dest, int destPos,
            int length);
 * */
public class OJ327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper)
                + countWhileMergeSort(sums, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        // cal count:
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower) k++;
            while (j < end && sums[j] - sums[i] <= upper) j++;
            count += j - k;
        }
        // merge:
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
            cache[r] = sums[i];
        }
        System.arraycopy(cache, 0, sums, start, t - start);
        // return:
        return count;
    }

    public static void main(String[] args) {
        OJ327 obj = new OJ327();
        System.out.println(obj.countRangeSum(new int[]{
                -2, 5, -1
        }, -2, 2));// 3
        // index:  [0, 0], [2, 2], [0, 2]  => sum: -2, -1, 2 => 3个区间


    }
}
