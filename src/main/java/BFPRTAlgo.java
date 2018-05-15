
import org.apache.hadoop.io.LongWritable;

import java.util.List;
import java.util.Map;


/**
 * Created by xiaoyue26 on 17/8/13.
 */
public class BFPRTAlgo {// for array
    /* 插入排序，返回中位数下标 */
    private static <T extends Comparable<T>> int InsertSort(T array[], int left, int right) {
        T temp;
        int j;
        for (int i = left + 1; i <= right; i++) {
            temp = array[i];
            j = i - 1;
            while (j >= left && array[j].compareTo(temp) > 0)
                array[j + 1] = array[j--];
            array[j + 1] = temp;
        }

        return ((right - left) >> 1) + left;
    }

    /* 返回中位数的中位数下标 */
    private static <T extends Comparable<T>> int GetPivotIndex(T array[], int left, int right) {
        if (right - left < 5)
            return InsertSort(array, left, right);

        int sub_right = left - 1;
        for (int i = left; i + 4 <= right; i += 5) {
            int index = InsertSort(array, i, i + 4);  //找到五个元素的中位数的下标
            swap(array, ++sub_right, index);   //依次放在左侧
        }

        return BFPRT(array, left, sub_right, ((sub_right - left + 1) >> 1) + 1);
    }

    /* 利用中位数的中位数的下标进行划分，返回分界线下标 */
    private static <T extends Comparable<T>> int Partition(T array[], int left, int right, int pivot_index) {
        swap(array, pivot_index, right);  //把基准放置于末尾

        int divide_index = left;  //跟踪划分的分界线
        for (int i = left; i < right; i++) {
            if (array[i].compareTo(array[right]) < 0)
                swap(array, divide_index++, i);  //比基准小的都放在左侧
        }

        swap(array, divide_index, right);  //最后把基准换回来
        return divide_index;
    }

    public static <T extends Comparable<T>> int BFPRT(T array[], int left, int right, int k) {
        int pivot_index = GetPivotIndex(array, left, right);            //得到中位数的中位数下标
        int divide_index = Partition(array, left, right, pivot_index);  //进行划分，返回划分边界
        int num = divide_index - left + 1;
        if (num == k)
            return divide_index;
        else if (num > k)
            return BFPRT(array, left, divide_index - 1, k);
        else
            return BFPRT(array, divide_index + 1, right, k - num);
    }

    private static void swap(Object[] a, int t, int i) {
        Object tmp = a[t];
        a[t] = a[i];
        a[i] = tmp;
    }

    public static void main(String[] args) {
        Integer[] list = {12, 2, 4, 1, 1, 2, 3, 100, 13};
        int index = BFPRT(list, 0, 8, 4);
        System.out.println(list[index]);
        System.out.println(Integer.MAX_VALUE);

    }



}
