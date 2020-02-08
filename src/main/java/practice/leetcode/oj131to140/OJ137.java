package practice.leetcode.oj131to140;

/**
 * Created by xiaoyue26 on 17/12/28.
 * 所有数字3次或1次.
 */
public class OJ137 {
    /**
     * 出现3次或1次;
     * 第一反应是数10进制每位加和后%3的值,然后拼起来;
     * 但是10进制比3进制大，所以会损失精度,原来结果是4,取模后就只剩下1了;
     * <p>
     * 理想: 3进制求和后取模;
     * 实际: 基本没有3进制运算符,转换成3进制太耗费时间;
     * <p>
     * 折中方案: 2进制求和模3,因为2进制比3小，所以不会损失精度;
     * 遍历32次,时间不是最优.
     * 最优的话可以用状态转移,只遍历一次,但是较难写出状态转移方程.
     */
    public int singleNumber_3ms(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) sum++;
            }
            sum %= 3;
            res |= (sum << i);
        }
        return res;
    }

    
    
    public int singleNumber_way1(int[] nums) {// k个计数器. 最多Integer.MAX_VALUE个. 空间O(K)
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int one = 0; // 截止目前出现1次
        int two = 0; // 截止目前出现2次或以上的
        int three; // 截止目前出现3次的数字
        for (int num : nums) {
            two |= one & num; // 这次以前出现奇次 且 这次出现. 即截止目前出现2次. 再或以前出现2次的. 即出现2次以上的.
            one ^= num; // 截止目前出现奇次.
            three = one & two; // 奇数且2次以上,按条件可以当做3次.
            one &= ~three;//  从one里去掉已经出现3次的.
            two &= ~three; // 从two里去掉已经出现3次的.
        }
        return one;
    }
    /*
    * ab: 00 => 01 => 10 => 00
    * b => if(a=0): b^num   // 此处a为上一次的a.
    *      elif(a=1): 0
    *
    * a => if(b=0): a^num // 此处b为这次的b.
    *      elif(b=1): 0
    *
    * 这个状态转移公式不唯一.
    * */
    public int singleNumber(int[] nums) {// k位计数器,设计每位状态转移的公式. 最多32位. 空间O(1)
        int a = 0, b = 0;
        for (int num : nums) {
            b = (b ^ num) & ~a;
            a = (a ^ num) & ~b;
        }
        return b;// 因为只有3次和1次. 每一位的计数器ab仅可能为 00和01, 因此a始终为0,b里恰好为结果.

    }

    public static void main(String[] args) {
        OJ137 obj = new OJ137();
        System.out.println(obj.singleNumber(new int[]{3, 1, 2, 2, 1, 3, 4, 1, 2, 3}));
    }


}
