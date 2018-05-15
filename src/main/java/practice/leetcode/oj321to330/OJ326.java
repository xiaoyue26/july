package practice.leetcode.oj321to330;

public class OJ326 {
    // private final int max3Power = 1162261467;
    private final int max3Power = (int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) / Math.log(3)));

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        return max3Power % n == 0;
    }

    public boolean isPowerOfThree_string(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    public static void main(String[] args) {
        OJ326 obj = new OJ326();
        System.out.println(obj.isPowerOfThree(13));
        System.out.println(obj.isPowerOfThree(9));
    }
}
