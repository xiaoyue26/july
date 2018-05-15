package practice.leetcode.utils;


import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by xiaoyue26 on 17/11/16.
 */
public class PrintUtils {

    private PrintUtils() {
    }

    public static void print(int[] nums) {
        List<Integer> res = Arrays.stream(nums).boxed().collect(Collectors.toList());
        log(res.toString());
    }
    public static void print(double[] nums) {
        List<Double> res = Arrays.stream(nums).boxed().collect(Collectors.toList());
        log(res.toString());
    }

    public static <T> void print(T[] nums) {
        for (T n : nums) {
            log(n.toString());
        }
    }

    public static void print(int[][] nums) {
        List<List<Integer>> res = Arrays.stream(nums).map(
                row -> (Arrays.stream(row).boxed().collect(Collectors.toList())))
                .collect(Collectors.toList());
        log(res.toString());
    }


    public static void log(String line) {
        System.out.println(line);
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 2, 4};
        print(nums);
        // to boxed Array
        Integer[] what = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Integer[] ever = IntStream.of(nums).boxed().toArray(Integer[]::new);
        Integer[] res = ArrayUtils.toObject(nums);

        // To boxed list
        List<Integer> you = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> like = IntStream.of(nums).boxed().collect(Collectors.toList());

    }
}
