package practice.leetcode.oj381to390;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyue26
 */
public class OJ386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            list.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else if (cur % 10 != 9 && cur + 1 <= n) {
                cur++;
            } else {
                while ((cur / 10) % 10 == 9) {
                    cur /= 10;
                }
                cur = cur / 10 + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        OJ386 obj = new OJ386();
        System.out.println(obj.lexicalOrder(13));
    }
}
