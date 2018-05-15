package hdfs;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.ContentSummary;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.util.*;


public class PeekHdfs {

    private static final Log log = LogFactory.getLog(PeekHdfs.class);
    private static final int RECORD_LIMIT = 256;
    public static Configuration conf = new Configuration();
    private static FileSystem hdfs;
    private String dt = getDt();
    private String yesterday = getYesterday();
    private String tbName = "pipe_ape.hdfs_size";

    static {
        conf.addResource("core-site.xml");
        conf.addResource("hdfs-site.xml");
        conf.addResource("mapred-site.xml");
        try {
            hdfs = FileSystem.get(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getDt() {
        Calendar calenday = Calendar.getInstance();
        int year = calenday.get(Calendar.YEAR);
        int month = calenday.get(Calendar.MONTH) + 1;
        int day = calenday.get(Calendar.DAY_OF_MONTH);
        return String.format("%d-%d-%d", year, month, day);
    }

    private static String getYesterday() {
        Calendar calenday = Calendar.getInstance();
        calenday.add(Calendar.DATE, -1);
        int year = calenday.get(Calendar.YEAR);
        int month = calenday.get(Calendar.MONTH) + 1;
        int day = calenday.get(Calendar.DAY_OF_MONTH);
        return String.format("%d-%d-%d", year, month, day);
    }

    public static class Dir {
        String name;
        long size;
        long diffSize;

        public Dir(String name, long size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public String toString() {
            return this.name + "," + this.size;
        }
    }

    public static class DirComparator implements Comparator<Dir> {
        @Override
        public int compare(Dir o1,
                           Dir o2) {
            return -Long.compare(o1.diffSize, o2.diffSize);
        }

    }

    public List<Dir> recordRoot(Path rootPath) throws IOException {
        return dig1(rootPath.getParent() + "/" + rootPath.getName());
    }

    public String path2String(Path path) {
        return path.getParent() + "/" + path.getName();
    }

    private List<Dir> dig1(String name) throws IOException {
        List<Dir> rootDirs = new ArrayList<>();
        FileStatus[] fss = hdfs.listStatus(new Path(name));
        for (FileStatus fs : fss) {
            Path f = fs.getPath();
            long size = hdfs.getContentSummary(f).getLength();
            Dir dir = new Dir(path2String(f), size);
            rootDirs.add(dir);
        }
        for (int i = 0; i < RECORD_LIMIT && i < rootDirs.size(); i++) {
            recordDir(rootDirs.get(i).name, rootDirs.get(i).size);
        }

        return rootDirs;
    }


    public void recordDir(String f, long size) {
        String sql = "replace into %s (dt,dir,size) values('%s','%s',%d)";
        sql = String.format(sql, tbName, dt, f, size);
        MysqlUtils.queryPipe(sql);
    }

    public String evaluate(String root) {
        Path rootPath = new Path(root);
        List<Dir> rootDirs;
        try {
            rootDirs = recordRoot(rootPath);
            // dig top10 3 times
            List<Dir> res = dig(rootDirs, 10, 1);
            return StringUtils.join(res, "\n");
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    private List<Dir> dig(List<Dir> rootDirs, int topN, int times) throws IOException {
        List<Dir> res = new ArrayList<>(100);
        List<Dir> input = rootDirs;
        for (int i = 0; i < times; i++) {
            List<Dir> nextInput = new ArrayList<>();
            List<Dir> topInput = getTopN(input, topN);
            for (Dir dir : topInput) {
                res.add(dir);
                nextInput.addAll(dig1(dir.name));
            }
            input = nextInput;
        }
        return res;
    }

    private List<Dir> getTopN(List<Dir> rootDirs, int topN) throws IOException {
        compareBack1(rootDirs);
        // get top n diff
        Collections.sort(rootDirs, new DirComparator());
        List<Dir> topNDirs = new ArrayList<>(topN);
        for (int i = 0; i < topN && i < rootDirs.size(); i++) {
            topNDirs.add(rootDirs.get(i));
        }
        return topNDirs;
    }

    private void compareBack1(List<Dir> rootDirs) throws IOException {
        for (Dir dir : rootDirs) {
            dir.diffSize = compareBack1(dir.name, dir.size);
        }
    }


    private long compareBack1(String f, long size) {
        String sql = "select size from %s where dir='%s' and dt='%s' limit 1";
        sql = String.format(sql, tbName, f, yesterday);
        List<List<Object>> rows =  MysqlUtils.queryPipe(sql);
        if (rows.size() > 0) {
            return size - (long) rows.get(0).get(0);
        } else {
            return 0;
        }
    }

    public static void main(String[]args) throws IOException {
        ContentSummary c=hdfs.getContentSummary(new Path("/lib"));
        System.out.println(c.getLength());
        System.out.println(c.getSpaceConsumed());// length * factor 三副本的话就是三倍

    }

}
