package practice.leetcode.oj481to490;

/**
 * @author xiaoyue26
 * a(a(1) + a(2) + … + a(k)) = (3 + (-1)k)/2
 */
public class OJ481 {

    public int magicalString(int n) {
        int[] magic = new int[n];
        int slow = 0, fast = 0, num = 1, count = 0;
        while (fast < n) {
            magic[fast++] = num;
            count += num & 1;
            if (fast < n && magic[slow++] == 2) {
                magic[fast++] = num;
                count += num & 1;
            }
            num ^= 3;
        }
        return count;
    }

    public static void main(String[] args) {
        OJ481 obj = new OJ481();
        System.out.println(obj.magicalString(6));//3
    }
}
