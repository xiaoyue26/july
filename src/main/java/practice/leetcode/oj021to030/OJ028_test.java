package practice.leetcode.oj021to030;

/**
 * Created by xiaoyue26 on 17/11/12.
 */
public class OJ028_test {


    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        char[] target = needle.toCharArray();
        char[] source = haystack.toCharArray();
        char first = target[0];
        int max = source.length - target.length;

        for (int i = 0; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;//  循环1
            }
            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + target.length - 1;
                for (int k = 1; j < end && source[j] == target[k]; j++, k++)// 循环2
                    ;

                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        OJ028_test obj = new OJ028_test();
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
     * 0       x   x'    k-1      i-k        x''  i-1,i
     *
     * 设i-1时,前缀为[0:k-1],后缀为[i-k:i-1].
     * 则i时,前缀在[0:k-1)范围内.
     *
     *
     *
     * 由于 [x'k-1]=[x'',i-1]
     * 如果找到一个 [0,x]=[x'',i-1]
     * 则 必有  [0,x]=[x',k-1]
     * 因此正好是[0,k-1]范围内的最大前缀后缀. (相似子结构)
     * */
}
