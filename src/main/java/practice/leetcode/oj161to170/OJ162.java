package practice.leetcode.oj161to170;

/**
 * Created by xiaoyue26 on 18/1/5.
 * nums[-1]=nums[n]=-∞
 * num[i] ≠ num[i+1]  // 邻居不相等
 */
public class OJ162 {
    public int findPeakElement(int[] nums) {// 返回极大值的下标
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[mid + 1]) {// 减小,go left
                r = mid;
            } else {// 增大,go right
                l = mid + 1;
            }
        }
        return l;
    }

    private int getI(int i, int nums[]) {
        if (i < 0 || i > nums.length - 1) {
            return Integer.MIN_VALUE;
        }
        return nums[i];
    }

    public static void main(String[] args) {
        OJ162 obj = new OJ162();
        System.out.println(obj.findPeakElement(new int[]{
                1, 2, 3, 1
        }));
    }
}
