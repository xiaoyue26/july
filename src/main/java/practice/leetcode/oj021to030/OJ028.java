package practice.leetcode.oj021to030;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 17/11/12.
 */
public class OJ028 {

    public int strStr_sunday(String haystack, String needle) {// sunday algo
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0 && haystack.length() == 0) {
            return 0;
        }
        /*int nextMap[] = new int[needle.length()];
        for (int i = 0; i < needle.length(); i++) {
            // nextMap.put(needle.charAt(i), needle.lastIndexOf(needle.charAt(i)));
            nextMap[i]=needle.lastIndexOf(needle.charAt(i));
        }*/

        int curEnd = needle.length() - 1;

        char next;
        int nextIndex;
        int i = 0;
        while (curEnd < haystack.length() && i < needle.length()) {
            if (haystack.charAt(curEnd - i) == needle.charAt(needle.length() - 1 - i)) {
                i++;
            } else {
                if (curEnd + 1 >= haystack.length()) {// already found
                    break;
                }
                next = haystack.charAt(curEnd + 1);
                nextIndex = needle.lastIndexOf(next);
                // nextIndex = nextMap[]//nextMap.getOrDefault(next, -1);
                if (nextIndex == -1) {
                    curEnd += needle.length() + 1;
                } else {
                    curEnd += needle.length() - nextIndex;
                }
                i = 0;
            }
        }
        if (i >= needle.length()) {
            return curEnd - needle.length() + 1;
        } else {
            return -1;
        }
    }

    public int strStr(String haystack, String needle) {// kmp algo
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }


        int next[] = new int[needle.length()];
        buildNext(needle, next); // k位置结尾的最大相同前后缀
        for (int k : next) {
            System.out.print(k + ",");
        }
        System.out.println();
        int i = 0, j = 0;
        while (j < needle.length() && i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else {
                if (j == 0) {
                    ++i;
                } else {
                    j = next[j - 1];
                }
            }
        }
        if (j == needle.length()) {// found:
            return i - j;
        } else { // not found:
            return -1;
        }
    }

    private void buildNext(String str, int[] next) {
        next[0] = 0;
        int pre = next[0];// 上一位置的最大前后缀长度
        for (int i = 1; i < str.length(); i++) {
            while (pre > 0 && str.charAt(i) != str.charAt(pre)) {
                pre = next[pre - 1];// 见注释K
            }
            if (str.charAt(i) == str.charAt(pre)) {
                ++pre;
            }
            next[i] = pre;
        }
    }


    public static void main(String[] args) {
        OJ028 obj = new OJ028();
        String str1 = "aabaaabaaac";
        String str2 = "aabaaac";
        System.out.println(obj.strStr(str1, str2));
        System.out.println(str1.indexOf(str2));
    }

    /*
     * 注释K:
     *
     * (1) 当 str[i] == str[k]:
     * 又多匹配了一个,k+=1,next[i]=k.
     *
     * (2) 当 str[i] != str[k]:
     * (2.1)如果之前k=0,(next[i-1]=0),那这次最多就是1了. (判断一下最后一位等不等)
     * (2.2)
     * 如果之前k>0,也就是next[i-1]=k>0;
     * 此时, str[0:k-1]=str[i-k:i-1] 且 str[k]!=str[i]
     * 直接拓展next[i-1]的成果失败.因此 next[i]<=next[i-1]
     *
     * +_______+___+______+________+_________+_____+,+
     * 0       x0   x1    k-1      i-k        x2  i-1,i
     *
     * 设i-1时,前缀为[0:k-1],后缀为[i-k:i-1].
     * 则i时,前缀在[0:k-1)范围内.
     *
     *
     *
     * 由于 [x1,k-1]=[x2,i-1];
     * 如果找到一个 [0,x0]=[x2,i-1];
     * 则 必有  [0,x0]=[x1,k-1];
     * 因此正好必定是[0,k-1]范围内的相同前缀后缀. (相似子结构)
     * 又因为[0,k-1]内最大的相同前缀后缀为next[k-1],因此所求的最大值为next[k-1].
     * */
}
