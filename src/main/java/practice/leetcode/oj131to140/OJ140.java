package practice.leetcode.oj131to140;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/12/30.
 */
public class OJ140 {

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
    public List<String> wordBreak(String s, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        if(!wordBreak(s,wordDict)){
            return new ArrayList<>();
        }
        List<List<String>> dp = new ArrayList<>(s.length());
        for (int i = 1; i < s.length() + 1; i++) {
            List<String> dpi = new ArrayList<>();
            dp.add(dpi);
            String stri = s.substring(0, i);
            if (wordDict.contains(stri)) {
                dpi.add(stri);
            }
            for (int j = 1; j < i; j++) {
                String strj = stri.substring(j, i);
                List<String> dpj = dp.get(j - 1);
                if (dpj.size() > 0 && wordDict.contains(strj)) {
                    for (String pre : dpj) {
                        dpi.add(pre + " " + strj);
                    }
                }
            }
        }


        return dp.get(s.length() - 1);
    }

    public static void main(String[] args) {
        OJ140 obj = new OJ140();
        System.out.println(obj.wordBreak("catsanddog", new ArrayList<>(Arrays.asList(
                "cat", "cats", "and", "sand", "dog"
        ))));
    }
}
