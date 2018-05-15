package practice.leetcode.utils;

/**
 * Created by xiaoyue26 on 17/12/10.
 */
public class RangeSum {
    private int[] tree;
    private int length;

    private int getLength(int n) {
        //叶子节点有n个的完全二叉树对应的满二叉树节点有多少个.
        // 节点数是 v0+v2=v0+(v0-1)=2n-1
        // h= log2(2n-1)+1
        // len= 2^h-1
        int height = (int) (Math.log(2 * n - 1) / Math.log(2) + 1);
        return (int) (Math.pow(2, height) - 1);
    }

    public void construct(int[] arr) {
        int len = getLength(arr.length);
        tree = new int[len];
        length = arr.length;
        construct(arr, 0, arr.length - 1, 0);
    }

    private int construct(int[] arr, int start, int end, int rootIndex) {
        if (start >= end) {
            tree[rootIndex] = arr[start];
            return tree[rootIndex];
        }
        int mid = start + ((end - start) >> 1);
        tree[rootIndex] = construct(arr, start, mid, rootIndex * 2 + 1)//construct left node
                + construct(arr, mid + 1, end, rootIndex * 2 + 2)//right node
        ;
        return tree[rootIndex];
    }

    public static void main(String[] args) {
        RangeSum obj = new RangeSum();
        int arr[] = {1, 3, 5, 7, 9, 11};
        obj.construct(arr);
        System.out.println(obj.querySum(1, 3));
        obj.update(1, 10);
        System.out.println(obj.querySum(1, 3));
    }

    public int querySum(int start, int end) {
        return querySum(0, length - 1, start, end, 0);
    }

    private int querySum(int start, int end, int qstart, int qend, int rootIndex) {
        if (start >= qstart && end <= qend) {
            return tree[rootIndex];
        }

        if (start > qend || end < qstart) {
            return 0;
        }
        int mid = start + ((end - start) >> 1);
        int left = querySum(start, mid, qstart, qend, 2 * rootIndex + 1);//left part
        int right = querySum(mid + 1, end, qstart, qend, rootIndex * 2 + 2);// right part
        return left + right;
    }

    public void update(int index, int value) {
        update(index, value, 0, length - 1, 0);
    }

    private int update(int index, int value, int start, int end, int rootIndex) {
        if (index < start || index > end) {
            return 0;
        }
        if (start == end) {// index==start
            int diff = value - tree[rootIndex];
            tree[rootIndex] += diff;
            return diff;
        }
        int mid = start + ((end - start) >> 1);
        int leftDiff = update(index, value, start, mid, rootIndex * 2 + 1);
        int rightDiff = update(index, value, mid + 1, end, rootIndex * 2 + 2);
        tree[rootIndex] += leftDiff + rightDiff;
        return leftDiff + rightDiff;
    }


}
