package practice.leetcode.utils;

import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/10.
 */
public class RangeMin {

    private int[] tree;

    public void construct(int[] arr) {
        tree = new int[arr.length];


    }

    public int rangeMin(int left, int right) {

        return 1;
    }

    public static void main(String[] args) {
        RangeMin obj = new RangeMin();

        int[] arr = {1, 2, 3, 4};
        obj.construct(arr);
        System.out.println(obj.rangeMin(0, 2));//1
        System.out.println(obj.rangeMin(2, 3));//3
    }
}
