package hbase.crud;

import hbase.crud.HBaseConnectionUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;

import java.io.IOException;

/**
 * Created by xiaoyue26 on 17/10/17.
 */
public class SingleTest {
    private static void test(){
        Connection connection = null;
        try {
            connection = HBaseConnectionUtils.getConnection();
            TableName tableName = TableName.valueOf("demo");
            String rowKey = "u12000";




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


    }
}
