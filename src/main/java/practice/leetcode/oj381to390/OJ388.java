package practice.leetcode.oj381to390;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiaoyue26
 * 目录没有点
 * 文件有点（file2.ext）
 */
public class OJ388 {
    public int lengthLongestPath(String input) {
        Deque<String> stack = new LinkedList<>();
        char cs[] = input.toCharArray();
        int maxLen = 0;
        StringBuilder curStr = new StringBuilder();
        boolean isFile = false;
        int stackTopIndex = 0;
        int curIndex = 0;
        for (char c : cs) {
            if (c == '\t') {
                curIndex++;
            } else if (c == '\n') {
                String s = curStr.toString();
                if (isFile) {
                    int curLen = s.length();
                    for (String dir : stack) {
                        curLen += dir.length() + 1;// 注意斜杠也算
                    }
                    maxLen = Math.max(maxLen, curLen);
                } else {
                    stack.push(s);
                    stackTopIndex++;
                }

                curStr = new StringBuilder();
                isFile = false;
                curIndex = 0;
            } else {
                while (curIndex < stackTopIndex) {
                    stackTopIndex--;
                    stack.pop();
                }
                if (c == '.') {
                    isFile = true;
                }
                curStr.append(c);
            }
        }
        if (isFile) {
            String s = curStr.toString();
            int curLen = s.length();
            for (String dir : stack) {
                curLen += dir.length() + 1;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        OJ388 obj = new OJ388();
        System.out.println(obj.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(obj.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\t" +
                "subsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));//32
        // aaaaaaaaaaaaaaaaaaaaa/sth.png 比 a/aa/aaa/file1.txt 长
    }
}
