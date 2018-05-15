package practice.leetcode.oj271to280;

/**
 * Created by jiuzhoumu on 2018/2/12.
 */
public class OJ278 {
    private boolean isBadVersion(int n) {
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                if (mid - 1 < 1 || !isBadVersion(mid - 1)) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        OJ278 obj = new OJ278();
        System.out.println(obj.firstBadVersion(2));
    }
}
