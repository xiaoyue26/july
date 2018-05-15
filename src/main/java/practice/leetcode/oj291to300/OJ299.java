package practice.leetcode.oj291to300;

/**
 * Created by jiuzhoumu on 2018/2/19.
 */
public class OJ299 {
    public String getHint(String secret, String guess) {
        int[] counts = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            counts[secret.charAt(i) - '0']++;
        }
        int A = 0, B = 0, cur, sec;
        for (int i = 0; i < guess.length(); i++) {
            cur = guess.charAt(i) - '0';
            sec = secret.charAt(i) - '0';
            if (cur == sec) {
                A++;
                if (counts[cur] > 0) {
                    counts[cur]--;
                } else {
                    B--;
                }
                continue;
            }
            if (counts[cur] > 0) {
                B++;
                counts[cur]--;
            }
        }

        return A + "A" + B + "B";
    }

    public static void main(String[] args) {
        OJ299 obj = new OJ299();
        System.out.println(obj.getHint("1807", "7810"));//1A3B
        System.out.println(obj.getHint("1123", "0111"));//1A1B
    }
}
