package practice.leetcode.oj451to460;

/**
 * @author xiaoyue26
 * 循环只能单向,不能来回跳
 */
public class OJ457 {
    public boolean circularArrayLoop_multiDirect(int[] nums) {
        int curIndex, tmp;
        for (int i = 0; i < nums.length; ++i) {
            curIndex = i;
            while (true) {
                tmp = curIndex;
                curIndex = (curIndex + nums[curIndex]) % nums.length;
                if (curIndex < 0) {
                    curIndex += nums.length;
                }
                nums[tmp] = 0;
                if (curIndex == tmp) {
                    break;
                }
                if (nums[curIndex] == 0) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        for (int i = 0; i < nums.length; i++) {
            if (checkCycle(nums, i)) return true;
        }
        return false;
    }

    private final int getNext(int[] nums, int start, int n) {
        return ((start + nums[start]) % n + n) % n;
    }

    public boolean checkCycle(int[] nums, int start) {
        int n = nums.length;
        int slow = getNext(nums, start, n);
        int fast = getNext(nums, slow, n);
        while (slow != fast) {
            slow = getNext(nums, slow, n);
            fast = getNext(nums, fast, n);
            fast = getNext(nums, fast, n);
        }
        if (slow == getNext(nums, slow, n)) return false;//one element loop
        boolean forward_backward = nums[slow] > 0;//forward or backword
        int ptr = getNext(nums, slow, n);
        while (ptr != slow) {
            if (nums[ptr] > 0 != forward_backward) return false;
            ptr = getNext(nums, ptr, n);
        }
        return true;
    }

    public static void main(String[] args) {
        OJ457 obj = new OJ457();
        System.out.println(obj.circularArrayLoop(new int[]{
                2, -1, 1, 2, 2
        }));
        System.out.println(obj.circularArrayLoop(new int[]{
                -1, 2
        }));
        System.out.println(obj.circularArrayLoop(new int[]{
                2, -1, 1, -2, -2
        })); // false
    }
}
