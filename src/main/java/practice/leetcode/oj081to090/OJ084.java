package practice.leetcode.oj081to090;

import java.util.Stack;

/**
 * Created by xiaoyue26 on 17/12/7.
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * 需要动脑子的解决方案. O(n)
 */
public class OJ084 {
    public int largestRectangleArea_dp(int[] heights) {//太慢
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int m = heights.length;
        int[][] min = new int[m][m];
        int max = 0;
        for (int i = 0; i < m; i++) {
            min[i][i] = heights[i];
            max = Math.max(max, min[i][i]);
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                min[i][j] = Math.min(heights[j], min[i][j - 1]);
                max = Math.max(max, min[i][j] * (j - i + 1));
            }
        }
        return max;
    }

    public int largestRectangleArea_old(int[] height) {
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (i < height.length) {
            if (stack.empty() || height[stack.peek()] < height[i]) {
                stack.push(i);
                i++;
            } else {
                int start = stack.pop();
                int width = stack.empty() ? i : i - stack.peek() - 1;
                area = Math.max(area, height[start] * width);
                // i stop;
            }
        }
        while (!stack.empty()) { // clear stack
            int start = stack.pop();
            int width = stack.empty() ? height.length : height.length
                    - stack.peek() - 1;
            area = Math.max(area, height[start] * width);
        }
        return area;
    }

    public static void main(String[] args) {
        OJ084 obj = new OJ084();
        int[] heights = new int[]{
                2, 1, 5, 6, 2, 3// ans: 10
                //1,2,1
        };
        System.out.println(obj.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int stack[] = new int[heights.length];
        int top = -1;
        for (int i = 0; i < heights.length; i++) {
            if (top == -1 || heights[stack[top]] < heights[i]) {
                stack[++top] = i;//push
            } else {
                int start = stack[top--];//pop
                int width;
                if (top == -1) {
                    width = i;
                } else {
                    width = i - stack[top] - 1;//peek
                }
                max = Math.max(width * heights[start], max);
                --i;// retry i
            }
        }
        while (top >= 0) {
            int start = stack[top--];//pop
            int width;
            if (top == -1) {// empty
                width = heights.length;
            } else {
                width = heights.length - stack[top] - 1;//peek
            }
            max = Math.max(width * heights[start], max);
        }
        return max;

    }
}
