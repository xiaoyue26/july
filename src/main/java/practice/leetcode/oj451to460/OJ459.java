package practice.leetcode.oj451to460;

/**
 * 判断s中是否有重复模式
 * @author xiaoyue26
 */
public class OJ459 {
    /**
     * 假设s中最大重复模式为c;
     * s=n个c;
     * (n=1时,s中没有重复模式)
     * 则 s+s = n*c+n*c
     * (s + s).substring(1, 2 * s.length() - 1)相当于损坏两个c;
     * 于是相当于: n*c+n*c-2c;
     * 当且仅当n>=2时,有
     * n*c+n*c-2c>=n*c
     * <=> n*c-2*c >=0
     * <=> n*c >= 2*c
     * <=> n>=2
     */
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }

    public static void main(String[] args) {
        OJ459 obj = new OJ459();
        System.out.println(obj.repeatedSubstringPattern("abab"));//true
        System.out.println(obj.repeatedSubstringPattern("aba"));//false
        System.out.println(obj.repeatedSubstringPattern("abcabcabcabc"));//true
    }
}