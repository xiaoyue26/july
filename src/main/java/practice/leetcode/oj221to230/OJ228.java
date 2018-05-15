package practice.leetcode.oj221to230;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyue26 on 18/1/31.
 */
public class OJ228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int next = nums[0];
        int left = nums[0];
        int right;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == next) {
                next++;
            } else {
                right = next - 1;
                // out put left->right
                output(left, right, res);
                // restart
                left = nums[i];
                next = left;
                i--;
            }
        }
        // output last
        right = next - 1;
        output(left, right, res);
        return res;
    }

    private void output(int left, int right, List<String> res) {
        if (left >= right) {
            res.add(String.valueOf(left));
        } else {
            res.add(left + "->" + right);
        }
    }

    public static void main(String[] args) {
        OJ228 obj = new OJ228();
        System.out.println(obj.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));// "0->2","4->5","7"
        System.out.println(obj.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));// "0","2->4","6","8->9"

    }
}
