package practice.leetcode.oj411to420;

/**
 * @author xiaoyue26
 */
public class OJ416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int counters[] = new int[101];
        for (int n : nums) {
            counters[n]++;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        return dfs(counters, target);
    }

    private boolean dfs(int[] counters, int target) {
        int rest;
        boolean flag;
        for (int i = 100; i >= 1; --i) {
            if (counters[i] > 0) {
                counters[i]--;
                rest = target - i;
                if (rest == 0) {
                    return true;
                } else if (rest < 0) {
                    // try next
                } else if (rest <= 100 && counters[rest] > 0) {
                    return true;
                } else {
                    flag = dfs(counters, rest);
                    if (flag) {
                        return true;
                    }
                }
                // try next
                counters[i]++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OJ416 obj = new OJ416();
        System.out.println(obj.canPartition(new int[]{
                1, 5, 11, 5
        }));
        System.out.println(obj.canPartition(new int[]{
                1, 2, 3, 5
        }));
        System.out.println(obj.canPartition(new int[]{
                1, 1
        }));
    }
}
