package practice.leetcode.oj371to380;

/**
 * @author xiaoyue26
 * 摆动子序列
 */
public class OJ376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int k = 0;
        while (k < nums.length - 1 && nums[k] == nums[k + 1]) {  //Skips all the same numbers from series beginning eg 5, 5, 5, 1
            k++;
        }
        if (k == nums.length - 1) {
            return 1;
        }
        int result = 2;     // This will track the result of result array
        boolean smallReq = nums[k] < nums[k + 1];       //To check series starting pattern
        for (int i = k + 1; i < nums.length - 1; i++) {
            if (smallReq && nums[i + 1] < nums[i]) {
                nums[result] = nums[i + 1];
                result++;
                smallReq = !smallReq;    //Toggle the requirement from small to big number
            } else {
                if (!smallReq && nums[i + 1] > nums[i]) {
                    nums[result] = nums[i + 1];
                    result++;
                    smallReq = !smallReq;    //Toggle the requirement from big to small number
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OJ376 obj = new OJ376();
        System.out.println(obj.wiggleMaxLength(new int[]{
                1, 7, 4, 9, 2, 5
        }));// 6
        System.out.println(obj.wiggleMaxLength(new int[]{
                1, 17, 5, 10, 13, 15, 10, 5, 16, 8
        }));// 7 // 1,17,10,13,10,16,8
        System.out.println(obj.wiggleMaxLength(new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9
        }));// 2

    }
}
