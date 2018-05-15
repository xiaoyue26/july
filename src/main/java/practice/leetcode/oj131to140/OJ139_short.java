package practice.leetcode.oj131to140;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/12/29.
 */
public class OJ139_short {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return wordBreak(s, wordSet);

    }

    private boolean wordBreak(String s, Set<String> wordSet) {
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i ; j++) {
                if(dp[i]){
                    break;
                }
                dp[i] = dp[j] && wordSet.contains(s.substring(j, i));

            }
        }

        return dp[s.length()];
    }


    public static void main(String[] args) {
        OJ139_short obj = new OJ139_short();
        System.out.println(obj.wordBreak("leetcode", new ArrayList<>(Arrays.asList(
                "leet", "code"
        ))));
    }
}
