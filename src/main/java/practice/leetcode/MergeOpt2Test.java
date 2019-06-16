package practice.leetcode;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author xiaoyue26
 */
public class MergeOpt2Test {

    // 尾递归进一步改写成循环: 核心思想是加个while true,然后疯狂改入参
    @SuppressWarnings("Duplicates")
    private void mergeSort(int[] nums) {
        int begin = 0;
        int length = nums.length;
        LinkedList<int[]> argStack = new LinkedList<>();
        boolean gotoWhile;
        while (true) {
            gotoWhile = false;
            if (length <= 1) {
                while (!argStack.isEmpty()) {
                    int[] args = argStack.pop();
                    if (args.length == 5) { //  need right sort:
                        argStack.push(new int[]{args[2], args[3], args[4]});
                        begin = args[0];
                        length = args[1];
                        gotoWhile = true;
                        break;
                    } else if (args.length == 3) {// right already sort,need merge:
                        merge(nums, args[0], args[1], args[2]);
                        // 继续弹栈
                    }
                }
                if (gotoWhile) {
                    continue;
                } else {
                    return;// 处理完了args
                }
            } else {// 疯狂压栈:
                argStack.push(new int[]{begin + length / 2, length - length / 2 // 2arg for right mergeSort
                        , begin, begin + length / 2, length // 3arg for merge
                });
                length = length / 2;
            }
        }
    }

    @SuppressWarnings("Duplicates")// 和MergeTest里的相同
    private void merge(int[] nums, int leftBegin, int rightBegin, int length) {
        int leftEnd = rightBegin - 1;
        int rightEnd = leftBegin + length - 1;
        int[] tmp = new int[length];// TODO 可重用
        int curIndex = -1;
        while (leftBegin <= leftEnd && rightBegin <= rightEnd) {
            if (nums[leftBegin] < nums[rightBegin]) {
                tmp[++curIndex] = nums[leftBegin];
                leftBegin++;
            } else {
                tmp[++curIndex] = nums[rightBegin];
                rightBegin++;
            }
        }
        while (leftBegin <= leftEnd) {
            tmp[++curIndex] = nums[leftBegin];
            leftBegin++;
        }
        while (rightBegin <= rightEnd) {
            tmp[++curIndex] = nums[rightBegin];
            rightBegin++;
        }
        // numHead = rightEnd-length+1
        for (int i = 0; i < length; i++) {
            nums[rightEnd - length + 1 + i] = tmp[i];
        }
    }


    public static void main(String[] args) {
        MergeOpt2Test obj = new MergeOpt2Test();
        int[] nums = new int[]{1, 5, 2, 11, 7, 3, 1, 6, 17, 10, 312, 312, 1, 1, 2323, 4, 56, 3, 14, 5543};
        obj.mergeSort(nums);

        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println();
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }

    }


}
