package practice.leetcode.oj331to340;

/*
 *  要求O(n)时间，O(1)空间
 *
 *  stack保存目前为止的最长子序列;
 *  newStack保存可能比stack更优,但目前还更短的栈班底.
 * */
public class OJ334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] stack = new int[3];
        int newStack = Integer.MAX_VALUE;
        int top = -1;
        int i = 0;
        while (i < nums.length && top < 2) {
            if (top == -1) {
                stack[++top] = nums[i];
            } else if (nums[i] > stack[top]) { // top>=0 增长子序列
                stack[++top] = nums[i];
            } else if (top == 0) { // && nums[i]<=stack[0] 才1个，直接重启
                stack[0] = nums[i];
            } else { // top==1 && nums[i] <= stack[1]
                if (newStack != Integer.MAX_VALUE) {
                    if (nums[i] > newStack) { // 发现长度为2的更优栈班底
                        stack[0] = newStack;
                        stack[1] = nums[i];
                        newStack = Integer.MAX_VALUE;
                    } else if (nums[i] < newStack) { // nums[i]<newStack<stack[0]<stack[1]
                        newStack = nums[i];
                    }
                    // else nums[i]==newStack: do nothing
                } else { // newStack之前没有
                    if (nums[i] < stack[1] && nums[i] > stack[0]) { // 更新栈顶
                        stack[1] = nums[i];
                    } else if (nums[i] < stack[0]) { // 记录下更优栈底
                        newStack = nums[i];
                    }
                }

            }
            i++;
        }
        return top >= 2;
    }

    public static void main(String[] args) {
        OJ334 obj = new OJ334();
        System.out.println(obj.increasingTriplet(new int[]{
                1, 2, 3, 4, 5
        }));// true
        System.out.println(obj.increasingTriplet(new int[]{
                5, 4, 3, 2, 1
        })); // false
        System.out.println(obj.increasingTriplet(new int[]{
                1, 10, 2, 9, 3, 8
        })); // true
        System.out.println(obj.increasingTriplet(new int[]{
                10, 1, 9, 2, 8, 3
        })); // true
        System.out.println(obj.increasingTriplet(new int[]{
                2, 3, 1, 4
        })); // true
        System.out.println(obj.increasingTriplet(new int[]{
                2, 3, 1, 1, 1, 1, 0, 4
        })); // true
        System.out.println(obj.increasingTriplet(new int[]{
                2, 3, 1, 1, 1, 1, 0, 2, 3
        })); // true

    }
}