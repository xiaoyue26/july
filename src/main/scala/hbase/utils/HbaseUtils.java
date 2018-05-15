package hbase.utils;

import hbase.crud.HBaseConnectionUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by xiaoyue26 on 17/10/21.
 * <p>
 * 其他更多操作看 June项目或者上网查一下吧
 */
public class HbaseUtils {
    public static final byte[] CF = "NEWCF".getBytes();// column family
    public static final byte[] ATTR = "attr".getBytes();// column key
    private static final String TABLE_NAME = "MYTABLE";
    // table -> row key -> column family -> column key
    /*
    *  GET:
     * 1. 用行键获得Result
     * 2. 从Result,用family和列qualifier获得具体的值.
     * 3. 把byte解开.
    * */
    public static void test1() throws IOException {
        Connection conn = HBaseConnectionUtils.getConnection();
        Table table = conn.getTable(TableName.valueOf(TABLE_NAME));
        Get get = new Get(Bytes.toBytes("112233bbbcccc"));// 行健
        Result r = table.get(get);
        System.out.println(resultValue(r));
        conn.close();
    }

    public static String resultValue(Result r) throws UnsupportedEncodingException {
        byte[] b = r.getValue(CF, ATTR);
        return new String(b, "utf-8");
    }

    public static void test2() throws IOException {// test scan
        Connection conn = HBaseConnectionUtils.getConnection();
        Table table = conn.getTable(TableName.valueOf(TABLE_NAME));
        Scan scan = new Scan();// all row
        ResultScanner scanner = table.getScanner(scan);
        Result r = scanner.next();
        while (r != null) {
            System.out.println(resultValue(r));
            r = scanner.next();
        }
        conn.close();
    }

    public static void main(String[] args) throws IOException {
        test2();
    }

}
