package hbase.utils;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.NavigableMap;

/**
 * Created by xiaoyue26 on 17/10/17.
 */
public class HbaseUtilsOld {
    private static final Logger logger = LoggerFactory.getLogger(HbaseUtilsOld.class);

    public static void scan(Connection connection, TableName tableName) throws IOException {
        Table table = null;

        NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> nmap;
        //Map.Entry<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> entry;
        try {
            table = connection.getTable(tableName);
            ResultScanner rs = null;
            try {
                //Scan scan = new Scan(Bytes.toBytes("u120000"), Bytes.toBytes("u200000"));
                rs = table.getScanner(new Scan());
                for (Result r : rs) {
                    nmap = r.getMap();
                    for (Map.Entry<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>>entry:
                         nmap.entrySet()) {
                        logger.info("row:{} key:{}"
                                , Bytes.toString(r.getRow()), Bytes.toString(entry.getKey()));
                        NavigableMap<byte[], NavigableMap<Long, byte[]>> valueMap
                                = entry.getValue();
                        for (Map.Entry<byte[], NavigableMap<Long, byte[]>> en
                                : valueMap.entrySet()) {
                            //System.out.print(Bytes.toString(en.getKey()) + "##");
                            NavigableMap<Long, byte[]> ma = en.getValue();
                            for (Map.Entry<Long, byte[]> e : ma.entrySet()) {
                                System.out.print(e.getKey() + "###");
                                System.out.println(Bytes.toString(e.getValue()));
                            }
                        }
                    }
                }
            } finally {
                if (rs != null) {
                    rs.close();
                }
            }
        } finally {
            if (table != null) {
                table.close();
            }
        }
    }

    public void get(Connection connection, TableName tableName, String rowKey) throws IOException {
        Table table = null;
        try {
            table = connection.getTable(tableName);
            Get get = new Get(Bytes.toBytes(rowKey));
            Result result = table.get(get);
            NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> navigableMap = result.getMap();
            for (Map.Entry<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> entry : navigableMap.entrySet()) {

                logger.info("columnFamily:{}", Bytes.toString(entry.getKey()));
                NavigableMap<byte[], NavigableMap<Long, byte[]>> map = entry.getValue();
                for (Map.Entry<byte[], NavigableMap<Long, byte[]>> en : map.entrySet()) {
                    System.out.print(Bytes.toString(en.getKey()) + "##");
                    NavigableMap<Long, byte[]> nm = en.getValue();
                    for (Map.Entry<Long, byte[]> me : nm.entrySet()) {
                        logger.info("column key:{}, value:{}", me.getKey(), me.getValue());
                    }
                }
            }
        } finally {
            if (table != null) {
                table.close();
            }
        }
    }
}
