package practice.leetcode.oj281to290;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiuzhoumu on 2018/2/15.
 */
public class OJ282 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, num.toCharArray(), 0, target, 0, 0);
        return res;

    }
    public void dfs(List<String> res, StringBuilder sb, char[] num, int pos, int target, long prev, long multi) {
        if(pos == num.length) {
            if(target == prev) res.add(sb.toString());
            return;
        }
        long curr = 0;
        for(int i = pos; i < num.length; i++) {
            if(num[pos] == '0' && i != pos) break;
            curr = 10 * curr + num[i] - '0';
            int len = sb.length();
            if(pos == 0) {
                dfs(res, sb.append(curr), num, i + 1, target, curr, curr);
                sb.setLength(len);
            } else {
                dfs(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr);
                sb.setLength(len);// 回溯
                dfs(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr);
                sb.setLength(len);
                dfs(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr);
                sb.setLength(len);
            }
        }
    }

    public static void main(String[] args) {
        OJ282 obj = new OJ282();
        System.out.println(obj.addOperators("123", 6));
    }
}
