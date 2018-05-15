package hbase.crud;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 *
 * 这个能用
 */
public class HBaseConnectionUtils {

    public static Connection getConnection() throws IOException {
        Connection connection = ConnectionFactory.createConnection(getConfiguration());
        return connection;
    }

    private static Configuration getConfiguration() throws IOException {
        Configuration config = HBaseConfiguration.create();
        config.addResource("hbase-site.xml");
        return config;
    }
}
