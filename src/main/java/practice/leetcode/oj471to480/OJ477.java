package practice.leetcode.oj471to480;

public class OJ477 {

    public int totalHammingDistance(int[] nums) {
        int res = 0, bitCount;
        for (int j = 0; j < 32; j++) {
            bitCount = 0;
            for (int num : nums) {// 所有num的第j位
                bitCount += (num >> j) & 1;
            }
            res += bitCount * (nums.length - bitCount);
        }
        return res;
    }

    public static void main(String[] args) {
        OJ477 obj = new OJ477();
        System.out.println(obj.totalHammingDistance(new int[]{
                        4, 14, 2
                }
        ));// 6
    }
}
