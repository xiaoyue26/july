package practice.performance;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author xiaoyue26
 * <p>
 * 测试用map和数组的性能差异
 */
public class Compute1 {
    private String[] opTypes = new String[]{
             "0X80066F4"
            , " 0X80066F8"
            , " 0X80066F9"
            , " 0X8007625"
            , " 0X8007626"
            , " 0X80081C3"
            , " 0X80081C4"
            , " 0X80081DB"
            , " 0X80081DC"
            , " 0X80091DC"
            , " 0X8007408"
            , " 0X8007409"
    };

    public static List<Map<Object[],Integer>> taskQueue;

    public void testMap() {


    }

    private void testArray() {
    }

    public static void main(String[] args) {
        Compute1 obj = new Compute1();
        Long begin, end;
        begin = System.currentTimeMillis();
        obj.testMap();
        end = System.currentTimeMillis();
        System.out.println("testMap duration:" + (end - begin) + "ms");// ms


        begin = System.currentTimeMillis();
        obj.testArray();
        end = System.currentTimeMillis();
        System.out.println("testArray duration:" + (end - begin) + "ms");// ms


    }


}
