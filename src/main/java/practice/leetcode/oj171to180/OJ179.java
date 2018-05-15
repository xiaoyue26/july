package practice.leetcode.oj171to180;

import practice.leetcode.utils.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by xiaoyue26 on 18/1/12.
 */
public class OJ179 {

    public String largestNumber(int[] input) {
        if (input == null || input.length == 0)
            return "";
        String[] nums = Arrays.stream(input)
                .mapToObj(String::valueOf)
                .toArray(size -> new String[input.length]);

        Comparator<String> cmp = (str1, str2) -> {
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s2.compareTo(s1);
        };

        Arrays.sort(nums, cmp);
        if (nums[0].charAt(0) == '0')
            return "0";
        return Arrays.stream(nums).collect(Collectors.joining());

    }

    public static void main(String[] args) {
        OJ179 obj = new OJ179();
        System.out.println(obj.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
