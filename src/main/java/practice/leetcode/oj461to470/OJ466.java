package practice.leetcode.oj461to470;

/**
 * @author xiaoyue26
 * 扫n1遍s1,其中s2出现了x次,
 * 则结果应该是x/n2次。
 *
 * 扫的过程中,大概率有重复（循环）模式,可以利用。
 *
 * s1="abacb", n1=6
 * s2="bcaa", n2=1
 * 第0次扫完s1后,需要的下一个字符是b,也就是下标0；
 * 第1次扫完s1后,需要的下一个字符是a,也就是下标2；
 * 第2次扫完s1后,需要的下一个字符是c,也就是下标1；
 * 第3次扫完s1后,需要的下一个字符是a,也就是下标2；// 出现循环
 *
 * 抽屉原理,如果扫的次数够多,一定会出现循环。
 * */
public class OJ466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int[] repeatCount = new int[s2.length() + 1];
        int[] nextIndex = new int[s2.length() + 1];
        repeatCount[0] = 0;
        nextIndex[0] = 0;// 第0遍扫描结束后,需要s2的第0个字符
        int j = 0, count = 0;
        for (int k = 1; k <= n1; k++) { // 扫n1遍
            for (int i = 0; i < s1.length(); i++) { // 扫一遍s1
                if (s1.charAt(i) == s2.charAt(j)) {
                    ++j;
                    if (j == s2.length()) {
                        j = 0;
                        ++count;
                    }
                }
            }
            repeatCount[k] = count;
            nextIndex[k] = j;
            // 检查是否发生了循环
            for (int start = 0; start < k; start++) {
                if (nextIndex[start] == j) {
                    // start遍扫描后增长量
                    int prefixCount = repeatCount[start];
                    // (start,k]之间增长量（每个周期增长量）.
                    // 其中: (k - start)=>周期的宽度； (n1 - start) / (k - start): 有几个周期
                    int patternCount = (repeatCount[k] - repeatCount[start]) * (n1 - start) / (k - start);
                    // n个周期后,剩下不足周期的部分: (n1 - start) % (k - start)
                    int suffixCount = repeatCount[start + (n1 - start) % (k - start)] - repeatCount[start];
                    return (prefixCount + patternCount + suffixCount) / n2;
                }
            }
        }
        // 直到最后都没循环(n1长度不够,而s2长度很长,导致没有达到抽屉原理的条件)
        return repeatCount[n1] / n2;
    }

    public static void main(String[] args) {
        OJ466 obj = new OJ466();
        System.out.println(obj.getMaxRepetitions(
                "acb", 4, "ab", 2));
    }
}
