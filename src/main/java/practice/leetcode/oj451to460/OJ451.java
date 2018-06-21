package practice.leetcode.oj451to460;

/**
 * @author xiaoyue26
 * 范围是char 0-255
 */
public class OJ451 {
    public String frequencySort(String s) {
        int counters[] = new int[256];
        char[] cs = s.toCharArray();
        int max = 0;
        for (char c : cs) {
            counters[c]++;
            max = Math.max(counters[c], max);
        }
        StringBuilder[] cache = new StringBuilder[max + 1];
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] > 0) {
                if (cache[counters[i]] == null) cache[counters[i]] = new StringBuilder();
                for (int j = 0; j < counters[i]; j++) {
                    cache[counters[i]].append((char) (i));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = cache.length - 1; i >= 0; --i) {
            if (cache[i] != null) {
                res.append(cache[i]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        OJ451 obj = new OJ451();
        System.out.println(obj.frequencySort("tree"));
        System.out.println(obj.frequencySort("cccaaa"));
        System.out.println(obj.frequencySort("Aabb"));//bbAa
    }
}
