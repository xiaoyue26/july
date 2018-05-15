package hdfs;


import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by xiaoyue26 on 17/11/6.
 */
public enum SingleEnum {
    INSTANCE;

    private DataSource dataSource;

    SingleEnum() {
    }

    public DataSource getDataSource() {
        return dataSource;
    }



}
