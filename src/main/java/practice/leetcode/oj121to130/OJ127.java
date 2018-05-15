package practice.leetcode.oj121to130;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/12/23.
 * 双端BFS.
 * 等效于一个边权重全部相等的最小距离问题. (图)
 */
public class OJ127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 因为要频繁相互确定能否到达,因此开始和结果域都用Set
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        Set<String>wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }

        int len = 1;
        HashSet<String> visited = new HashSet<>();

        beginSet.add(beginWord);// 设置两个搜索起点.
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) { // 都不为空才行. 因此上一步BFS不能是无处可去.
            if (beginSet.size() > endSet.size()) { // swap.
                // 确保beginSet小. 这样比较快. 去掉也可以,但会慢很多.
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> nextLevelSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {// 退出条件.
                            // 检查是否能到达endSet
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordSet.contains(target)) {
                            // 可以作为下一步.
                            nextLevelSet.add(target);
                            visited.add(target);// 避免重复被作为起点.
                        }
                        chs[i] = old;// 回溯
                    }
                }
            }

            beginSet = nextLevelSet;// 更新beginSet.
            len++;
        }

        return 0;
    }

    public static void main(String[] args) {
        OJ127 obj = new OJ127();
        List<String> wordList = new ArrayList<>(Arrays.asList(
                "hot", "dot", "dog", "lot", "log", "cog"
        ));
        System.out.println(obj.ladderLength("hit", "cog", wordList));
    }
}
