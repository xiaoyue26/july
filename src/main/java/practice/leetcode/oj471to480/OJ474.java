package practice.leetcode.oj471to480;

/**
 * @author xiaoyue26
 */
public class OJ474 {
    public int findMaxForm(String[] strs, int m, int n) {
        //let's assume weight of each string given is 1
        //then we need to find what combination of strings in strs
        // gives us the maximum net value

        //say, dp[i][m][n] <- number of strings using m zeroes, n ones
        // considering only first i strings in strs

        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            int[] cnt = weight(strs[i - 1]);
            for (int mi = 0; mi <= m; mi++) {
                for (int ni = 0; ni <= n; ni++) {
                    if (mi == 0 && ni == 0)
                        dp[i][mi][ni] = 0;
                    else if (cnt[0] <= mi && cnt[1] <= ni) {
                        //考虑是否用上最后一个str
                        dp[i][mi][ni] = Math.max(
                                1 + dp[i - 1][mi - cnt[0]][ni - cnt[1]]
                                , dp[i - 1][mi][ni]);
                    } else {
                        dp[i][mi][ni] = dp[i - 1][mi][ni];
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    int[] weight(String s) {
        int[] i = new int[2];
        for (char c : s.toCharArray()) {
            i[(c == '0' ? 0 : 1)]++;
        }

        return i;
    }


    public static void main(String[] args) {
        OJ474 obj = new OJ474();
        System.out.println(obj.findMaxForm(new String[]{
                "10", "0001", "111001", "1", "0"
        }, 5, 3));
        System.out.println(obj.findMaxForm(new String[]{
                "10", "1", "0"
        }, 1, 1));
    }
}
