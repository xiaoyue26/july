package practice.leetcode.oj461to470;


import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaoyue26
 * 太低效了,没有考虑超长p的情况
 */
public class OJ467_old {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }
        Set<String> segments = getUniqSegments(p);
        Set<String> visited = new HashSet<>();
        for (String seg : segments) {
            updateVisited(seg, visited);
        }
        return visited.size();
    }

    private void updateVisited(String seg, Set<String> visited) {
        if (visited.contains(seg)) {
            return;
        }
        visited.add(seg);
        if (seg.length() > 1) {
            updateVisited(seg.substring(0, seg.length() - 1), visited);
            updateVisited(seg.substring(1, seg.length()), visited);
        }
    }

    private Set<String> getUniqSegments(String p) {
        char[] cs = p.toCharArray();
        Set<String> res = new HashSet<>();
        int head = 0;
        int i;
        for (i = 1; i < cs.length; i++) {
            if (!i1ThenI2(cs, i - 1, i)) {
                res.add(new String(cs, head, i - head));
                head = i;
            }
        }
        res.add(new String(cs, head, i - head));
        return res;
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
        OJ467_old obj = new OJ467_old();
        System.out.println(obj.findSubstringInWraproundString("a"));
        System.out.println(obj.findSubstringInWraproundString("cac"));
        System.out.println(obj.findSubstringInWraproundString("zab"));
    }
}
