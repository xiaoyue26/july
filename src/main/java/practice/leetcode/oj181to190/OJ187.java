package practice.leetcode.oj181to190;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaoyue26 on 18/1/12.
 * s only consists of ACGT
 * 10位串 出现2次及以上.(重复出现的模式)
 */
public class OJ187 {
    public List<String> findRepeatedDnaSequences(String s) {// 由于只有4个字母,可以重写hashcode,简化过程.
        Set<String> wordSet = new HashSet<>();
        Set<String> resSet = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String cur = s.substring(i, i + 10);
            if (wordSet.contains(cur)) {
                resSet.add(cur);
            } else {
                wordSet.add(cur);
            }
        }
        return new ArrayList<>(resSet);
    }

    public static void main(String[] args) {
        OJ187 obj = new OJ187();
        System.out.println(obj.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
