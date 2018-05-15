package practice.leetcode.oj091to100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/12.
 * ip范围0-9,10-99,100-199,200-255
 */
public class OJ093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return res;
        }
        dfs(s, res, 4, new ArrayList<>());
        return res;
    }

    private void dfs(String s, List<String> res, int num, List<String> tmp) {
        if (num == 0 && s.length() == 0) {
            StringBuilder cur = new StringBuilder(tmp.get(0));
            for (int i = 1; i < 4; i++) {
                cur.append(".").append(tmp.get(i));
            }
            res.add(cur.toString());
        }
        if (num == 0 || s.length() == 0) {
            return;
        }
        if (s.length() > 0 && isValid(s.substring(0, 1))) {
            tmp.add(s.substring(0, 1));
            dfs(s.substring(1), res, num - 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
        if (s.length() > 1 && isValid(s.substring(0, 2))) {
            tmp.add(s.substring(0, 2));
            dfs(s.substring(2), res, num - 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
        if (s.length() > 2 && isValid(s.substring(0, 3))) {
            tmp.add(s.substring(0, 3));
            dfs(s.substring(3), res, num - 1, tmp);
            tmp.remove(tmp.size() - 1);
        }


    }

    private boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int value = Integer.valueOf(s);
        if (s.length() == 1) {
            if (value >= 0 && value <= 9) {
                return true;
            } else {
                return false;
            }
        }

        if (s.length() == 2) {
            if (value >= 10 && value <= 99) {
                return true;
            } else {
                return false;
            }
        }
        if (s.length() == 3) {
            if (value >= 100 && value <= 255) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OJ093 obj = new OJ093();
        System.out.println(obj.restoreIpAddresses("25525511135"));//"255.255.11.135", "255.255.111.35"
        System.out.println(obj.restoreIpAddresses("35525511135"));
    }
}
