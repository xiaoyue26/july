package simple;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/16.
 */
public class Player {


    public void run(String configPath) throws IOException {
        Config conf = new Config();
        List<String> lines = FileUtils.readLines(new File(configPath));
        for (String line : lines) {
            line = StringUtils.trim(line);
            String[] words = line.split("\\s", 2);
            if (words.length < 2) {
                continue;
            }
            conf.add(words[0], words[1]);
        }
        conf.printStatus();


        System.out.println("here");
    }


    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("参数: 配置文件");
            System.exit(-1);
        }
        /* 预命令s(cd xxx),命令s,开始日期,结束日期
        *  step,pool_size,threshold
        * */
        Player obj = new Player();
        obj.run(args[0]);

        int nums[]={1,4,3,2};
        Arrays.sort(nums);





    }
}
