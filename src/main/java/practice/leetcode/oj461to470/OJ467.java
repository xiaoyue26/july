package practice.leetcode.oj461to470;

/**
 * @author xiaoyue26
 * dp
 * <p>
 * 状态定义:
 * 以x结尾的最大递增子串长度
 */
public class OJ467 {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }
        int count[] = new int[26];
        int curLen = 1;
        char[] cs = p.toCharArray();
        count[cs[0] - 'a'] = 1;
        for (int i = 1; i < cs.length; i++) {
            if (i1ThenI2(cs, i - 1, i)) {
                curLen++;
            } else {
                curLen = 1;
            }
            count[cs[i] - 'a'] = Math.max(count[cs[i] - 'a'], curLen);
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }

    // i1数据之后是i2的数据
    private boolean i1ThenI2(char[] cs, int i1, int i2) {
        if (cs[i2] == cs[i1] + 1) {
            return true;
        } else if (cs[i1] == 'z' && cs[i2] == 'a') {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        OJ467 obj = new OJ467();
        System.out.println(obj.findSubstringInWraproundString("a"));
        System.out.println(obj.findSubstringInWraproundString("cac"));
        System.out.println(obj.findSubstringInWraproundString("zab"));
    }
}
