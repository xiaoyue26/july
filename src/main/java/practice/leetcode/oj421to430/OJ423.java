package practice.leetcode.oj421to430;

/**
 * @author xiaoyue26
 */
public class OJ423 {
    public String originalDigits(String s) {
        int res[] = new int[10];
        int letters[] = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            letters[c - 'a']++;
        }
        countWord(letters, res, "zero", 'z', 0);
        countWord(letters, res, "two", 'w', 2);
        countWord(letters, res, "four", 'u', 4);
        countWord(letters, res, "six", 'x', 6);
        countWord(letters, res, "eight", 'g', 8);
        countWord(letters, res, "three", 't', 3);
        countWord(letters, res, "five", 'f', 5);
        countWord(letters, res, "seven", 'v', 7);
        countWord(letters, res, "nine", 'i', 9);
        countWord(letters, res, "one", 'o', 1);
        return res2string(res);
    }

    private String res2string(int[] res) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            while (res[i] > 0) {
                sb.append((char) ('0' + i));
                res[i]--;
            }
        }
        return sb.toString();
    }

    private void countWord(int[] letters, int[] res, String word, char uniqChar, int index) {
        while (letters[uniqChar - 'a'] > 0) {
            res[index]++;
            for (int i = 0; i < word.length(); i++) {
                letters[word.charAt(i) - 'a']--;
            }
        }
    }


    public static void main(String[] args) {
        OJ423 obj = new OJ423();
        System.out.println(obj.originalDigits("owoztneoer"));
        System.out.println(obj.originalDigits("fviefuro"));
    }
}
