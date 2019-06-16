package practice.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoyue26
 */
public class DfsTestToWhile {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, n);
        return list;
    }

    // 2 改成递归:
    @SuppressWarnings("Duplicates")
    public void dfs(List<String> list, int n) {
        String str = "";
        int open = 0;
        int close = 0;
        int max = n;
        LinkedList<Object[]> argsStack = new LinkedList<>();
        boolean gotoWhile;
        while (true) {
            gotoWhile = false;
            if (str.length() == max * 2) {
                list.add(str);
                while (!argsStack.isEmpty()) {
                    Object[] args = argsStack.pop();
                    str = (String) args[0];
                    open = (int) args[1];
                    close = (int) args[2];
                    max = (int) args[3];
                    gotoWhile = true;
                    break;
                }
                if (gotoWhile) {
                    continue; // 原来的递归调用改成continue While
                } else {
                    return; // 原来的出口中的return才是真的return
                }
            } else if (open < max) {
                if (close < open) {
                    argsStack.push(new Object[]{
                            str + ")", open, close + 1, max
                    });
                }
                str = str + "(";
                open = open + 1;
                continue; // 原来的递归调用改成continue While
                // // 原来的出口外的return 也改成 continue While
            } else {
                if (close < open) {
                    str = str + ")";
                    close = close + 1;
                    continue;
                } else {
                    continue;
                }
            }
        }
    }


    public static void main(String[] args) {
        DfsTestToWhile obj = new DfsTestToWhile();
        System.out.println(obj.generateParenthesis(0));
        System.out.println(obj.generateParenthesis(1));
        System.out.println(obj.generateParenthesis(2));
        System.out.println(obj.generateParenthesis(3));
        System.out.println(obj.generateParenthesis(4));
    }

}
