package practice.leetcode.oj241to250;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyue26 on 18/2/6.
 */
public class OJ241 {
    /*public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        int[] tmp = new int[1];
        tmp[0] = 0;
        Deque<Integer>numStack=new LinkedList<>();
        Deque<Character>opStack=new LinkedList<>();
        dfs(input,tmp,numStack,opStack,res);
        return res;
    }

    private void dfs(String input, int[] tmp, Deque<Integer> numStack, Deque<Character> opStack, List<Integer> res) {

    }*/
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                for (int x : al) {
                    for (int y : bl) {
                        if (c == '-') {
                            res.add(x - y);
                        } else if (c == '+') {
                            res.add(x + y);
                        } else if (c == '*') {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }

    public static void main(String[] args) {
        OJ241 obj = new OJ241();
        System.out.println(obj.diffWaysToCompute("2-1-1"));
        System.out.println(obj.diffWaysToCompute("2*3-4*5"));
    }
}
