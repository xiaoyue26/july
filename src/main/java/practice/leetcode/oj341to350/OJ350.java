package practice.leetcode.oj341to350;

import practice.leetcode.utils.PrintUtils;

import java.util.*;

/**
 * 这里用的二分查找
 * 也可以用hashMap
 * @author xiaoyue26
 */
public class OJ350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new LinkedList<>();
        Arrays.sort(nums1);
        boolean[] visited = new boolean[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            if (binarySearch(nums1, nums2[i], visited)) {
                res.add(nums2[i]);
            }
        }

        int r[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;

    }

    private boolean binarySearch(int[] nums, int x, boolean[] visited) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (x < nums[mid]) {
                right = mid - 1;
            } else if (x > nums[mid]) {
                left = mid + 1;
            } else {
                if (visited[mid]) {
                    if (nums[left] != x) {
                        left++;
                    } else if (visited[left]) {
                        left++;
                    } else {
                        visited[left] = true;
                        return true;
                    }
                } else {
                    visited[mid] = true;
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        OJ350 obj = new OJ350();
        PrintUtils.print(obj.intersect(new int[]{1, 2, 2, 1}
                , new int[]{2, 2}));// 2,2
        PrintUtils.print(obj.intersect(new int[]{1}
                , new int[]{1, 1}));// 1
    }
}
