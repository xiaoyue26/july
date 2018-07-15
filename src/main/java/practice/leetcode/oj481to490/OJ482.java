package practice.leetcode.oj481to490;

/**
 * @author xiaoyue26
 */
public class OJ482 {

    public String licenseKeyFormatting(String S, int K) {
        char[] cs = S.toCharArray();
        int validEnd = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 'a' && cs[i] <= 'z') {
                cs[validEnd] = (char) (cs[i] - 'a' + 'A');
                validEnd++;
            } else if (cs[i] >= 'A' && cs[i] <= 'Z'
                    || cs[i] >= '0' && cs[i] <= '9') {
                cs[validEnd] = cs[i];
                validEnd++;
            }
        }
        // now,real_len=cur
        if (validEnd == 0) {
            return "";
        }
        if (K >= validEnd) {
            return new String(cs, 0, validEnd);
        }
        // div to K parts,each len = cur/K
        int wordLen = K;
        int partsNum = (int) Math.ceil((double) validEnd / K);
        StringBuilder sb = new StringBuilder(validEnd + partsNum - 1);
        int firstLen = validEnd - (partsNum - 1) * wordLen;
        sb.append(cs, 0, firstLen);
        for (int i = 0; i < partsNum - 1; i++) {
            sb.append('-');
            sb.append(cs, firstLen + i * wordLen, wordLen);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        OJ482 obj = new OJ482();
        System.out.println(obj.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(obj.licenseKeyFormatting("2-5g-3-J", 2));
    }
}