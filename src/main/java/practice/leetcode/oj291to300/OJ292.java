package practice.leetcode.oj291to300;

/**
 * Created by jiuzhoumu on 2018/2/18.
 */
public class OJ292 {
    public boolean canWinNim(int n) {
        if (n % 4 == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        OJ292 obj = new OJ292();
        System.out.println(obj.canWinNim(4));
    }
}
