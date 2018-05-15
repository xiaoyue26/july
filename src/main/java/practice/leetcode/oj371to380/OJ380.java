package practice.leetcode.oj371to380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoyue26
 * 要求下列操作O(1)
 * insert(val)
 * remove(val)
 * getRandom  主要是这个操作难以O(1)
 */
public class OJ380 {
    static class RandomizedSet {

        List<Integer> nums;
        Map<Integer, Integer> locs;
        java.util.Random rand = new java.util.Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            nums = new ArrayList<>();
            locs = new HashMap<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean contain = locs.containsKey(val);
            if (contain) return false;
            locs.put(val, nums.size());
            nums.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            boolean contain = locs.containsKey(val);
            if (!contain) return false;
            int loc = locs.get(val);
            if (loc < nums.size() - 1) { // 为了保持长度字段（value）正确，用最后一个元素补位
                int lastone = nums.get(nums.size() - 1);
                nums.set(loc, lastone);
                locs.put(lastone, loc);
            }
            locs.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(1));// true
        System.out.println(randomSet.remove(2));// false
        System.out.println(randomSet.insert(2));// true
        System.out.println(randomSet.getRandom());// 1 or 2
        System.out.println(randomSet.remove(1));// true
        System.out.println(randomSet.insert(2));// true
        System.out.println(randomSet.getRandom()); // 2

    }

}
