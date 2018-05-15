package job.utils;


import org.apache.commons.lang.time.DateUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/8/5.
 */
public class MysqlUtils {
    private static String driver = "com.mysql.jdbc.Driver";

    private static String getUrl(String host, String db, String user, String passwd) {
        return String.format("jdbc:mysql://%s:3306/%s?user=%s&password=%s"
                , host, db, user, passwd);
    }

    public static List<List<Object>> query(String sql, String host, String db, String user, String passwd) {
        String url = getUrl(host, db, user, passwd);
        Connection conn;
        List<List<Object>> rows = new ArrayList<List<Object>>();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData resultMeta = resultSet.getMetaData();
            int num = resultMeta.getColumnCount();
            if (num < 1) return rows;
            while (resultSet.next()) {
                List<Object> row = new ArrayList<Object>();
                for (int i = 1; i < num + 1; i++) {
                    row.add(resultSet.getObject(i));
                }
                rows.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    public static List<List<Object>> query(String sql) {
        String host = "localhost";
        String db = "pipe";
        String user = "root";
        String passwd = "mysql";
        return query(sql, host, db, user, passwd);
    }

    public static void test1() {
        String sql = "select * from test";
        //val sql = "replace into test(name,col1)values('test_name','1')"
        String host = "localhost";
        String db = "pipe_ape";
        String user = "root";
        String password = "mysql";
        List<List<Object>> rows = query(sql, host, db, user, password);
        for (List<Object> row : rows) {
            for (Object obj : row) {
                if (null != obj)
                    System.out.print(obj.getClass() + " : ");
                else
                    System.out.print("null : ");
                System.out.print(obj);
                System.out.print(",");
            }
            System.out.println();
        }
    }

    public static void test2() {
        String host = "localhost";
        String db = "pipe_ape";
        String user = "root";
        String password = "mysql";
        String sql = "replace into pipe_ape.hdfs_size (dt,dir,size) values('%s','%s',%d)";
        sql = String.format(sql, "2017-10-27", "/", 0);
        MysqlUtils.query(sql, host, db, user, password);
    }

    public static void main(String[] args) {
        test2();

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.print(String.format("%d-%d-%d", year, month, day));

    }
}
