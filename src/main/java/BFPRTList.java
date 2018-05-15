
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.LongWritable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/8/14.
 */
public class BFPRTList { // for list
    private static final Log LOG = LogFactory.getLog(BFPRTList.class);

    /* 插入排序，返回中位数下标 */
    private static <T extends Comparable<T>> int InsertSort(List<T> array, int left, int right) {
        T temp;
        int j;
        for (int i = left + 1; i <= right; i++) {
            temp = array.get(i);
            j = i - 1;
            while (j >= left && array.get(j).compareTo(temp) > 0)
                array.set(j + 1, array.get(j--));
            array.set(j + 1, temp);
        }

        return ((right - left) >> 1) + left;
    }

    /* 返回中位数的中位数下标 */
    private static <T extends Comparable<T>> int GetPivotIndex(List<T> array, int left, int right) {
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
    private static <T extends Comparable<T>> int Partition(List<T> array, int left, int right, int pivot_index) {
        swap(array, pivot_index, right);  //把基准放置于末尾

        int divide_index = left;  //跟踪划分的分界线
        for (int i = left; i < right; i++) {
            if (array.get(i).compareTo(array.get(right)) < 0)
                swap(array, divide_index++, i);  //比基准小的都放在左侧
        }

        swap(array, divide_index, right);  //最后把基准换回来
        return divide_index;
    }

    public static <T extends Comparable<T>> int BFPRT(List<T> array, int left, int right, int k) {
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

    private static <T extends Comparable<T>> void swap(List<T> array, int t, int i) {
        T tmp = array.get(t);
        array.set(t, array.get(i));
        array.set(i, tmp);
    }

    public static void main(String[] args) {
        List<LongWritable> list = new ArrayList<LongWritable>();
        Integer[] test = {133347, 450721, 450723, 450725, 739713, 743497, 777087, 811813, 852089, 995209, 1073031, 1328225, 1405777, 1507433, 1547861, 1555955, 1830090, 1873319, 1873327, 1887621, 1903591, 1913619, 1918095, 1919171, 1929841, 1931351, 1935831, 1936745, 2045997, 2046203, 2046385, 2046387, 2046395, 2046589, 2046599, 2047043, 2047099, 2047111, 2047703, 2047725, 2047737, 2047743, 2047765, 2048423, 2048433, 2048487, 2048581, 2048635, 2048639, 2048651, 2048659, 2048671, 2048673, 2048761, 2048823, 2048845, 2048953, 2048963, 2048983, 2049011, 2049017, 2049525, 2049563, 2049611, 2049655, 2049735, 2049791, 2050099, 2050711, 2050941, 2051571, 2052301, 2052311, 2052325, 2052985, 2053033, 2053037, 2053049, 2053305, 2053313, 2054121, 2054197, 2063627, 2064263, 2065785, 2065791, 2070913, 2071531, 2071533, 2078415, 2078435, 2081185, 2084209, 2084231, 2088045, 2088049, 2088063, 2088121, 2088529, 2088531, 2088545, 2088655, 2088817, 2089013, 2089025, 2089045, 2089135, 2090615, 2090619, 2091645, 2091649, 2091655, 2091669, 2091851, 2091891, 2092591, 2093493, 2093571, 2093577, 2093621, 2093631, 2094707, 2094723, 2094729, 2094731, 2094745, 2095621, 2095625, 2095641, 2095645, 2095651, 2095807, 2095815, 2096395, 2096425, 2096445, 2096481, 2096559, 2096583, 2096621, 2096679, 2096775, 2097425, 2097955, 2097957, 2097963, 2098099, 2098723, 2100111, 2100119, 2100123, 2100129, 2100131, 2100139, 2100565, 2100569, 2100591, 2100613, 2100625, 2100759, 2100779, 2100781, 2100791, 2100801, 2100803, 2101501, 2244111, 2245269, 2251835, 2251903, 2253217, 2253241, 2253249, 2253299, 2253303, 2253305, 2253467, 2253645, 2253665, 2253687, 2254053, 2254427, 2258793, 2259599, 2259701, 2261087, 2261133, 2261177, 2261183, 2261665, 2261853, 2261867, 2261969, 2276049, 2276067, 2276307};
        for (Integer t : test) {
            list.add(new LongWritable(t));
        }
        int index = BFPRT(list, 0, 195, 97);
        System.out.println(index);
        System.out.println(list.get(index));
        System.out.println(Integer.MAX_VALUE);

    }


}
