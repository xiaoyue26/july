package practice.grammer;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by xiaoyue26 on 18/1/7.
 */
public class SkipListTest {
    public void test1() {
        Map<Integer, Integer> map = new ConcurrentSkipListMap<>();
        map.put(1, 2);
        map.replace(1, 2, 3);
        System.out.println(map.get(1));


    }

    public static void main(String[] args) {
        SkipListTest obj = new SkipListTest();
        obj.test1();
        System.out.println("there");
    }
}
