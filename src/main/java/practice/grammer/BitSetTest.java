package practice.grammer;

import java.util.BitSet;

/**
 * @author xiaoyue26
 */
public class BitSetTest {
    public void test() {
        int[] array = new int[]{1, 2, 3, 22, 0, 3};
        BitSet bitSet = new BitSet(6);
        //将数组内容组bitmap
        for (int i = 0; i < array.length; i++) {
            bitSet.set(array[i], true);
        }
        System.out.println(bitSet);
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(3));
    }

    public void test2() {
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);

        // set some bits
        for (int i = 0; i < 16; i++) {
            if ((i % 2) == 0) bits1.set(i);
            if ((i % 5) != 0) bits2.set(i);
        }
        System.out.println("Initial pattern in bits1: ");
        System.out.println(bits1);
        System.out.println("\nInitial pattern in bits2: ");
        System.out.println(bits2);

        // AND bits
        bits2.and(bits1);
        System.out.println("\nbits2 AND bits1: ");
        System.out.println(bits2);

        // OR bits
        bits2.or(bits1);
        System.out.println("\nbits2 OR bits1: ");
        System.out.println(bits2);

        // XOR bits
        bits2.xor(bits1); // 注意此前bits2发生了变化
        System.out.println("\nbits2 XOR bits1: ");
        System.out.println(bits2);
    }

    public static void main(String[] args) {
        BitSetTest obj = new BitSetTest();
        obj.test();
        obj.test2();
        System.out.println("there");
    }
}
