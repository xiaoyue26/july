package practice.leetcode.oj331to340;

/*               i-2
    case 1 : i-1┌─┐
                └─┼─>i
                 i-3

                    i-2
    case 2 : i-1 ┌────┐
                 └─══>┘i-3
                 i  i-4      (i overlapped i-4)

    case 3 :    i-4
               ┌──┐
               │i<┼─┐
            i-3│ i-5│i-1
               └────┘
                i-2

*/
public class OJ335 {
    public boolean isSelfCrossing(int[] x) {
        if (x.length <= 3) {
            return false;
        }

        for (int i = 3; i < x.length; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) { // 4th cross 1st
                return true;
            }
            if (i >= 4) {
                if (x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {// 5th cross 1st
                    return true;
                }
            }
            if (i >= 5) {
                if (x[i - 2] - x[i - 4] >= 0
                        && x[i] >= x[i - 2] - x[i - 4]
                        && x[i - 1] >= x[i - 3] - x[i - 5]
                        && x[i - 1] <= x[i - 3]) {// 6th cross 1st
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OJ335 obj = new OJ335();
        System.out.println(obj.isSelfCrossing(new int[]{
                2, 1, 1, 2
        }));
        System.out.println(obj.isSelfCrossing(new int[]{
                1, 2, 3, 4
        }));
        System.out.println(obj.isSelfCrossing(new int[]{
                1, 1, 1, 1
        }));
    }
}