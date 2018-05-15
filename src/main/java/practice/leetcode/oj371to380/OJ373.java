package practice.leetcode.oj371to380;

import practice.leetcode.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xiaoyue26
 */
public class OJ373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> que = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<int[]> res = new ArrayList<>(k);
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
        for (int i = 0; i < nums1.length && i < k; i++) {
            que.offer(new int[]{nums1[i], nums2[0], 0});//  num1[i],num2[0],0(num2下标)
        }
        while (k-- > 0 && !que.isEmpty()) {
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if (cur[2] != nums2.length - 1) { // 找出自己的继任者放入堆中
                que.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});// num1[x],num2[y],y
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OJ373 obj = new OJ373();
        List<int[]> res = obj.kSmallestPairs(new int[]{
                1, 7, 11
        }, new int[]{
                2, 4, 6
        }, 3);
        for (int[] r : res) {
            PrintUtils.print(r);
        }// [1,2],[1,4],[1,6]
        // [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

        res = obj.kSmallestPairs(new int[]{
                1, 1, 2
        }, new int[]{
                1, 2, 3
        }, 2);
        for (int[] r : res) {
            PrintUtils.print(r);
        }// [1,1],[1,1]
        // [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

        res = obj.kSmallestPairs(new int[]{
                1, 2
        }, new int[]{
                3
        }, 3);
        for (int[] r : res) {
            PrintUtils.print(r);
        }// [1,3],[2,3] 不足k对

    }
}
