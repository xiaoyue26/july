package practice.leetcode.oj071to080;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/2.
 */
public class OJ071 {
    public String simplifyPath(String path) {
        if (path == null || path.length() < 1) {
            return "/";
        }
        List<String> res = new ArrayList<>();
        boolean flag = false;
        int top = -1;
        if (path.charAt(0) == '/') {
            flag = true;
        }
        StringBuilder word = new StringBuilder();
        for (int i = 1; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case '.':
                    int count = 0;
                    while (i<path.length()&&path.charAt(i) == '.') {
                        i++;
                        count++;
                    }
                    if (count >= 2) {
                        if (top >= 0) {
                            top--;
                        }
                    }
                    --i;
                    break;
                case '/':
                    if (word.length() > 0) {
                        top++;
                        if (res.size() > top) {
                            res.set(top, word.toString());
                        } else {
                            res.add(word.toString());
                        }
                        word = new StringBuilder();
                    }
                    // end word
                    break;
                default:
                    word.append(path.charAt(i));
                    break;

            }

        }
        // deal last word
        if (word.length() > 0) {
            top++;
            if (res.size() > top) {
                res.set(top, word.toString());
            } else {
                res.add(word.toString());
            }
        }
        if (top == -1) {
            return "/";
        }
        StringBuilder sb = new StringBuilder(top + 1);
        if (flag) {
            sb.append('/');
        }
        for (int i = 0; i < top; i++) {
            sb.append(res.get(i)).append('/');
        }
        if (top >= 0) {
            sb.append(res.get(top));
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        OJ071 obj = new OJ071();
        System.out.println(obj.simplifyPath("/a/./b/../../c/"));
        System.out.println(obj.simplifyPath("/home"));
        System.out.println(obj.simplifyPath("/hom//sdf/"));
        System.out.println(obj.simplifyPath(""));
        System.out.println(obj.simplifyPath("../"));
        System.out.println(obj.simplifyPath("/..//"));
        System.out.println(obj.simplifyPath("/..."));
        System.out.println(obj.simplifyPath("a/b/c"));// 处理不了相对路径
    }
}
