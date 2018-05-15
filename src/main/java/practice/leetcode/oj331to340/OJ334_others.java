package practice.leetcode.oj331to340;

/*
 *  别人的解法，简洁很多，但是无法求出三元组具体是什么. 而我的可以。(但我的复杂很多)
 *
 *  与我的解法比较, 它是把newStack直接存到了small里.
 *  把我解法进行多次化简(逻辑演算),可以化到和它一样。
 *
 *  但从我的解法出发理解有点麻烦，直接粗略的理解：
 *  维护一个当前的长度为2的升序序列(小的值叫small, 大的叫big)，
 *  如果碰到比第二个值大的说明可以找到升序的三个值。
 *  并且在过程中不断更新small和big的值，使得他们最小。
 * */
public class OJ334_others {
    public boolean increasingTriplet(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) {
                small = n;
            } // update small if n is smaller than both
            else if (n <= big) {
                big = n;
            } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }

    public static void main(String[] args) {
        OJ334_others obj = new OJ334_others();
        System.out.println(obj.increasingTriplet(new int[]{
                1, 2, 3, 4, 5
        }));// true
        System.out.println(obj.increasingTriplet(new int[]{
                5, 4, 3, 2, 1
        })); // false
        System.out.println(obj.increasingTriplet(new int[]{
                1, 10, 2, 9, 3, 8
        })); // true
        System.out.println(obj.increasingTriplet(new int[]{
                10, 1, 9, 2, 8, 3
        })); // true
        System.out.println(obj.increasingTriplet(new int[]{
                2, 3, 1, 4
        })); // true
        System.out.println(obj.increasingTriplet(new int[]{
                2, 3, 1, 1, 1, 1, 0, 4
        })); // true
        System.out.println(obj.increasingTriplet(new int[]{
                2, 3, 1, 1, 1, 1, 0, 2, 3
        })); // true

    }
}