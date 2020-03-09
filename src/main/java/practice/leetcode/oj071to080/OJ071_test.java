package practice.leetcode.oj071to080;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/2.
 */
public class OJ071_test {
    public String simplifyPath(String path) {
        if (path == null || path.length() < 1) {
            return "/";
        }

        List<String> wordList = new LinkedList<>();
        int dotCount = 0;
        int left = 0;
        boolean isWord = false;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            switch (c) {
                case '.':
                    dotCount += 1;
                    if(dotCount>=3){
                        isWord=true;
                    }
                    break;
                case '/':
                    // do clean
                    doClean(path, left, i, wordList, dotCount, isWord);
                    isWord = false;
                    left = i + 1;
                    dotCount = 0;
                    break;
                default:
                    isWord = true;
                    break;
            }
        }
        // do clean
        doClean(path, left, path.length(), wordList, dotCount, isWord);
        if (wordList.size() == 0) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String word : wordList) {
            sb.append("/").append(word);
        }
        return sb.toString();
    }

    private void doClean(String path, int left, int i, List<String> wordList, int dotCount, boolean isWord) {
        if (left < i && isWord) {
            wordList.add((path.substring(left, i)));
        } else {
            if (dotCount == 2 && wordList.size() > 0) {
                wordList.remove(wordList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        OJ071_test obj = new OJ071_test();
        System.out.println(obj.simplifyPath("/a/./b/../../c/"));
        System.out.println(obj.simplifyPath("/home"));
        System.out.println(obj.simplifyPath("/hom//sdf/"));
        System.out.println(obj.simplifyPath(""));
        System.out.println(obj.simplifyPath("../"));
        System.out.println(obj.simplifyPath("/..//"));
        System.out.println(obj.simplifyPath("/..."));
        System.out.println(obj.simplifyPath("a/b/c"));
        System.out.println(obj.simplifyPath("/a//b////c/d//././/.."));
        System.out.println(obj.simplifyPath("/...hidden"));
        System.out.println(obj.simplifyPath("/....hidden"));
        System.out.println(obj.simplifyPath("/...hidden."));
        System.out.println(obj.simplifyPath("/..hidden"));
    }
}
