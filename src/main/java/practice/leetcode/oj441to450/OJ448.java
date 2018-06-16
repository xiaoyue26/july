package practice.leetcode.oj441to450;

/**
 * @author xiaoyue26
 */
import java.util.LinkedList;
import java.util.List;

public class OJ448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int tmp, index;
        for (int i = 1; i <= nums.length; i++) {
            index = i;
            while (nums[index - 1] != index && nums[index - 1] != -1) {
                tmp = nums[nums[index - 1] - 1];
                if (nums[index - 1] != tmp) {
                    nums[nums[index - 1] - 1] = nums[index - 1];
                    nums[index - 1] = tmp;
                } else {
                    nums[index - 1] = -1;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        OJ448 obj = new OJ448();
        System.out.println(obj.findDisappearedNumbers(new int[]{
                4, 3, 2, 7, 8, 2, 3, 1
                //-1 2  3  4        7
        }));
    }
}
