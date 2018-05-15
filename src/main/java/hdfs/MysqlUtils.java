package hdfs;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;


import javax.sql.DataSource;

/**
 * Created by xiaoyue26 on 17/11/6.
 */
public class MysqlUtils {
    public static void test1() throws SQLException, PropertyVetoException {
        System.out.println("here");

    }

    static DataSource a;

    public static void main(String[] args) throws PropertyVetoException, SQLException {
        MysqlUtils obj = new MysqlUtils();
        //obj.test1();
        System.out.println("there");
        System.out.println(SingleEnum.INSTANCE);



    }

    public static List<List<Object>> queryPipe(String sql) {
        return null;
    }
}
