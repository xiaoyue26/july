package practice.leetcode;


import java.util.*;

/**
 * @author xiaoyue26
 */
public class DfsTest {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        LinkedList<Object[]> argsStack = new LinkedList<>();
        dfs(list, "", 0, 0, n, argsStack);
        return list;
    }

    // 1 首先改成尾递归:
    public void dfs(List<String> list, String str
            , int open, int close, int max, LinkedList<Object[]> argsStack) {
        if (str.length() == max * 2) {
            list.add(str);
            while (!argsStack.isEmpty()) {
                Object[] args = argsStack.pop();
                String a1 = (String) args[0];
                int open1 = (int) args[1];
                int close1 = (int) args[2];
                int max1 = (int) args[3];
                dfs(list, a1, open1, close1, max1, argsStack);
                return;
            }
        }
        if (open < max) {
            if (close < open) {
                argsStack.push(new Object[]{
                        str + ")", open, close + 1, max
                });
            }
            dfs(list, str + "(", open + 1, close, max, argsStack);
        } else {
            if (close < open) {
                dfs(list, str + ")", open, close + 1, max, argsStack);
            } else {
                return;
            }
        }

    }


    public static void main(String[] args) {
        DfsTest obj = new DfsTest();
        System.out.println(obj.generateParenthesis(3));
    }

}
