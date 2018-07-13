package practice.leetcode.oj471to480;

public class OJ477_bu {

    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                tmp = nums[i] ^ nums[j];
                while (tmp != 0) {
                    tmp &= tmp - 1;
                    res += 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OJ477_bu obj = new OJ477_bu();
        System.out.println(obj.totalHammingDistance(new int[]{
                        4, 14, 2
                }
        ));// 6
    }
}
