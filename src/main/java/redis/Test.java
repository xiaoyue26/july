package redis;

import java.util.Set;

/**
 * Created by xiaoyue26 on 18/1/9.
 */
public class Test {
    public void test1() {
        System.out.println("here");

        String[] idArr = "13,14".split(",");
        for (String id : idArr) {
            System.out.println(Integer.valueOf(id));
        }

    }

    public static void main(String[] args) {
        Test obj = new Test();
        obj.test1();
        System.out.println("there");
    }
}
