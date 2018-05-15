package practice.leetcode.oj271to280;

/**
 * Created by jiuzhoumu on 2018/2/11.
 */
public class OJ275 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int left = 0, right = citations.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (citations[mid] >= citations.length - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return citations.length - left;
    }

    public static void main(String[] args) {
        OJ275 obj = new OJ275();
        System.out.println(obj.hIndex(new int[]{
                0, 1, 3, 5, 6
        }));
    }
}
