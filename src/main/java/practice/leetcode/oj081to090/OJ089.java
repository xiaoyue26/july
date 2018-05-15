package practice.leetcode.oj081to090;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/10.
 * 以二进制为0值的格雷码为第零项，第一项改变最右边的位元，第二项改变右起第一个为1的位元的左边位元
 * ，第三、四项方法同第一、二项，如此反复，即可排列出n个位元的格雷码。
 * G(i)= (i/2)^i
 */
public class OJ089 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i^(i>>1));
        }
        return res;
    }

    public static void main(String[] args) {
        OJ089 obj = new OJ089();
        System.out.println(obj.grayCode(3));
    }
}
