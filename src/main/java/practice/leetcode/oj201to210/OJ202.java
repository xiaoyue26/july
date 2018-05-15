package practice.leetcode.oj201to210;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyue26 on 18/1/16.
 */
public class OJ202 {
    public boolean isHappy_old(int n) {
        Set<Integer> set = new HashSet<>();
        while(true) {
            if(n==0){
                return false;
            }
            if(n==1){
                return true;
            }
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            int nextN=0;
            while(n!=0){
                nextN+=(n%10)*(n%10);
                n/=10;
            }
            n=nextN;
        }
    }
    private int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n>0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while(slow != fast);
        if (slow == 1) return true;
        else return false;
    }

    public static void main(String[] args) {
        OJ202 obj = new OJ202();
        System.out.println(obj.isHappy(19));
    }
}
