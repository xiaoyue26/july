package practice.leetcode.oj481to490;

/**
 * @author xiaoyue26
 */
public class OJ488 {
    private final int MAXCOUNT = 6;   // the max balls you need will not exceed 6 since "The number of balls in your hand won't exceed 5"

    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (int i = 0; i < hand.length(); ++i) ++handCount[hand.charAt(i) - 'A'];
        int rs = dfs(board + "#", handCount);  // append a "#" to avoid special process while j==board.length, make the code shorter.
        return rs == MAXCOUNT ? -1 : rs;
    }

    private int dfs(String board, int[] hand) {
        board = removeConsecutive(board);
        if (board.equals("#")) return 0;
        int rs = MAXCOUNT, need;
        for (int i = 0, j = 0; j < board.length(); ++j) {
            if (board.charAt(j) == board.charAt(i)) continue; // 贪心: 跳过了布局玩法, 因此遗漏了部分能解开的输入
            need = 3 - (j - i);     // balls need to remove current consecutive balls.
            if (hand[board.charAt(i) - 'A'] >= need) {
                hand[board.charAt(i) - 'A'] -= need;
                rs = Math.min(rs, need + dfs(board.substring(0, i) + board.substring(j), hand));
                hand[board.charAt(i) - 'A'] += need; // backtrace
            }
            i = j;
        }
        return rs;
    }

    //remove consecutive balls longer than 3
    private String removeConsecutive(String board) {
        for (int i = 0, j = 0; j < board.length(); ++j) {
            if (board.charAt(j) == board.charAt(i)) continue;
            if (j - i >= 3) return removeConsecutive(board.substring(0, i) + board.substring(j));
            else i = j;
        }
        return board;
    }


    public static void main(String[] args) {
        OJ488 obj = new OJ488();
        System.out.println(obj.findMinStep("WRRBBW", "RB")); // -1
        System.out.println(obj.findMinStep("WWRRBBWW", "WRBRW"));// 2
        System.out.println(obj.findMinStep("G", "GGGGG"));// 2
        System.out.println(obj.findMinStep("RBYYBBRRB", "YRBGB")); //3
        System.out.println(obj.findMinStep("RRWWRRBBRR", "WB")); // 正确是2; 但贪心法会跳过，因此会返回-1
    }
}
