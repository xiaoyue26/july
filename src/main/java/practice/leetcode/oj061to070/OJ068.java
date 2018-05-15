package practice.leetcode.oj061to070;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/2.
 */
public class OJ068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        dfs(words, 0, maxWidth, res);
        return res;

    }

    public void dfs(String[] words, int begin, int maxWidth, List<String> res) {
        if (words == null || begin >= words.length) {
            return;
        }
        // deal line
        int len = words[begin].length();
        int i;
        for (i = begin + 1; i < words.length && len + 1 + words[i].length() <= maxWidth; ++i) {
            len += 1 + words[i].length();
        }
        if(i>=words.length){
            String cur=join(words, ' ', begin, i)+repeat(' ', maxWidth - len);
            res.add(cur);
            return;
        }

        if (len < maxWidth) {// pad
            if (i - begin - 1 == 0) {
                words[begin] += repeat(' ', maxWidth - len);

            } else {
                int num = i - begin - 1;//n 个单词 n-1个空隙
                int avg = (maxWidth - len) / num;
                int rest = (maxWidth - len) % num;

                for (int j = begin; j < begin + rest; j++) {
                    words[j] += repeat(' ', avg + 1);
                }
                for (int j = begin + rest; j < i - 1; j++) {
                    words[j] += repeat(' ', avg);
                }
            }

        }
        res.add(join(words, ' ', begin, i));


        dfs(words, i, maxWidth, res);
    }

    private String repeat(char c, int times) {
        char[] cs = new char[times];
        Arrays.fill(cs, c);
        return new String(cs);
    }

    private String join(String[] words, char sep, int begin, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = begin; i < end - 1; i++) {
            sb.append(words[i]).append(sep);
        }
        sb.append(words[end - 1]);
        return sb.toString();
    }


    public static void main(String[] args) {
        OJ068 obj = new OJ068();
        String[] words = {
                //"This", "is", "an", "example", "of", "text", "justification."
                "What","must","be","shall","be."

        };
        System.out.println(obj.fullJustify(words, 12));
        // 每行最长16,不能分割单词,可以插入空格. 空格左优先.
        // 有点类似前端题

        String tets = StringUtils.join(words, ' ', 0, 2);
        System.out.println(tets);
    }
}
