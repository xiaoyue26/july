package practice.leetcode.oj011to020;

/**
 * Created by xiaoyue26 on 17/11/5.
 */
public class OJ011 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int max = (r - l) * Math.min(height[l], height[r]);
        while (l < r) {
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
            int len = Math.min(height[l], height[r]);
            max = Math.max(len * (r - l), max);
        }
        return max;

    }

    public static void main(String[] args) {
        OJ011 obj = new OJ011();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(obj.maxArea(height));
    }
}
